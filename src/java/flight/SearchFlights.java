package flight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fare.FareInfoBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shraddha
 */
@WebServlet(urlPatterns = {"/SearchFlights"})
public class SearchFlights extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        try (PrintWriter out = response.getWriter()) {
            String deptAirCode = request.getParameter("DeptAirCode");
            String arrAirCode = request.getParameter("ArrAirCode");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?zeroDateTimeBehavior=convertToNull","root","connect");
            Statement stmt = con.createStatement();
            
            String flightQuery = null;
            int flightNum1 = 0, flightNum2 = 0, flightNum3 = 0;
            String weekdays = null, weekdays1 = null, weekdays2 = null, weekdays3 = null;
            String sourceCode, interCode,interCode1, arrCode = null;
            String sourceTime, interTime, interTime1, arrTime = null;
            FareInfoBean fareInfoBean = null;
            ResultSet resultSet = null;
            ArrayList<FareInfoBean> flightData = new ArrayList<FareInfoBean>();
            String flightType = request.getParameter("type");
            
            if(flightType == null || flightType == "")
                flightType = "Nonstop";
            if(flightType.equalsIgnoreCase("nonstop")){
                flightQuery = "select flight_number, weekdays, Airline , Scheduled_departure_time , Scheduled_arrival_time  from flight "
                    +" where departure_airport_code = '"+deptAirCode+"' AND ARRIVAL_AIRPORT_CODE = '"+arrAirCode+"'";
                resultSet = stmt.executeQuery(flightQuery);
                System.out.println("Query::"+flightQuery);
                while (resultSet.next()){
                        flightNum1 = resultSet.getInt("flight_number");
                        weekdays = resultSet.getString("weekdays");
                        fareInfoBean = new FareInfoBean();
                        fareInfoBean.setFlightNum(flightNum1);
                        fareInfoBean.setWeekdays(weekdays);
                        fareInfoBean.setDepCode(deptAirCode);
                        fareInfoBean.setArrCode(arrAirCode);
                        flightData.add(fareInfoBean);
                }
                session.setAttribute("flightData",flightData);
                response.sendRedirect("SearchInfo1.jsp"); 
            }
            else if(flightType.equalsIgnoreCase("1-stop")){
                flightQuery = "select f1.Flight_number as no1, f2.Flight_number as no2, "
                        + "f1.Weekdays as w1, f2.Weekdays as w2,"
                        + "f1.Departure_airport_code as d1 , f1.Arrival_airport_code as i1, f2.Arrival_airport_code as a1,"
                        + "f1.Scheduled_departure_time as t1, f1.Scheduled_arrival_time as t2,"
                        + "f2.Scheduled_Departure_time as t3, f2.Scheduled_arrival_time as t4 "
                        + "from FLIGHT f1 join FLIGHT f2 "
                        + "on (f2.Departure_airport_code=f1.Arrival_airport_code and "
                        + "f2.Scheduled_Departure_time>=DATE_ADD(f1.Scheduled_arrival_time,INTERVAL 1 HOUR)) "
                        + "where f1.Departure_airport_code='"+deptAirCode+"' AND "
                        + "f2.Arrival_airport_code='"+arrAirCode+"' AND "
                        + "(f1.Weekdays NOT like '%Mon%' or f2.Weekdays like '%Mon%') and"
                        + " (f1.Weekdays NOT like '%Tue%' or f2.Weekdays like '%Tue%') and "
                        + "(f1.Weekdays NOT like '%Wed%' or f2.Weekdays like '%Wed%') and "
                        + "(f1.Weekdays NOT like '%Thu%' or f2.Weekdays like '%Thu%') and "
                        + "(f1.Weekdays NOT like '%Fri%' or f2.Weekdays like '%Fri%') and "
                        + "(f1.Weekdays NOT like '%Sat%' or f2.Weekdays like '%Sat%') and "
                        + "(f1.Weekdays NOT like '%Sun%' or f2.Weekdays like '%Sun%')";
                
                resultSet = stmt.executeQuery(flightQuery);
                System.out.println("Query::"+flightQuery);
                while (resultSet.next()){
                        flightNum1 = resultSet.getInt("no1");
                        flightNum2 = resultSet.getInt("no2");
                        weekdays1 = resultSet.getString("w1");
                        weekdays2 = resultSet.getString("w2");
                        sourceCode = resultSet.getString("d1");
                        interCode = resultSet.getString("i1");
                        arrCode = resultSet.getString("a1"); 
                        sourceTime = resultSet.getString("t1"); 
                        interTime = resultSet.getString("t2"); 
                        interTime1 = resultSet.getString("t3"); 
                        arrTime =  resultSet.getString("t4");
                        fareInfoBean = new FareInfoBean();
                        fareInfoBean.setFlightNum1(flightNum1);
                        fareInfoBean.setFlightNum2(flightNum2);
                        fareInfoBean.setWeekdays1(weekdays1);
                        fareInfoBean.setWeekdays2(weekdays2);
                        fareInfoBean.setDepCode(sourceCode);
                        fareInfoBean.setInterCode(interCode);
                        fareInfoBean.setArrCode(arrAirCode);
                        fareInfoBean.setSourceTime(sourceTime);
                        fareInfoBean.setInterTime(interTime);
                        fareInfoBean.setInterTime1(interTime1);
                        fareInfoBean.setArrTime(arrTime);
                        flightData.add(fareInfoBean);
                    }
                    session.setAttribute("flightData",flightData);
                    response.sendRedirect("SearchInfo.jsp");   
            }
            else if(flightType.equalsIgnoreCase("2-stop")){
                flightQuery = "Select f1.Flight_number as no1, f2.Flight_number as no2, f3.Flight_number as no3, "
                        + "f1.Departure_airport_code as d1,f1.Arrival_airport_code as i1, f2.Arrival_airport_code as i2 , "
                        + "f3.Arrival_airport_code as a1, f1.Weekdays as w1, f2.Weekdays as w2,f3.Weekdays as w3 "
                        + " from FLIGHT as f1 join FLIGHT as f2 join FLIGHT as f3 "
                        + "on (f1.Arrival_airport_code=f2.Departure_airport_code AND "
                        + "f2.Arrival_airport_code=f3.Departure_airport_code) and "
                        + "timediff(f2.Scheduled_Departure_time,f1.Scheduled_arrival_time)>'01:00:00' "
                        + "and timediff(f3.Scheduled_Departure_time,f2.Scheduled_arrival_time)>'01:00:00' "
                        + "where f1.Departure_airport_code='"+deptAirCode+"' AND "
                        + "f3.Arrival_airport_code='"+arrAirCode+"' AND "
                        + "(f1.Weekdays NOT like '%Mon%' or f2.Weekdays like '%Mon%') and "
                        + "(f1.Weekdays NOT like '%Tue%' or f2.Weekdays like '%Tue%') and "
                        + "(f1.Weekdays NOT like '%Wed%' or f2.Weekdays like '%Wed%') and "
                        + "(f1.Weekdays NOT like '%Thu%' or f2.Weekdays like '%Thu%') and "
                        + "(f1.Weekdays NOT like '%Fri%' or f2.Weekdays like '%Fri%') and "
                        + "(f1.Weekdays NOT like '%Sat%' or f2.Weekdays like '%Sat%') and "
                        + "(f1.Weekdays NOT like '%Sun%' or f2.Weekdays like '%Sun%') and "
                        + "(f2.Weekdays NOT like '%Mon%' or f3.Weekdays like '%Mon%') and "
                        + "(f2.Weekdays NOT like '%Tue%' or f3.Weekdays like '%Tue%') and "
                        + "(f2.Weekdays NOT like '%Wed%' or f3.Weekdays like '%Wed%') and "
                        + "(f2.Weekdays NOT like '%Thu%' or f3.Weekdays like '%Thu%') and "
                        + "(f2.Weekdays NOT like '%Fri%' or f3.Weekdays like '%Fri%') and "
                        + "(f2.Weekdays NOT like '%Sat%' or f3.Weekdays like '%Sat%') and "
                        + "(f2.Weekdays NOT like '%Sun%' or f3.Weekdays like '%Sun%')";

                resultSet = stmt.executeQuery(flightQuery);
                System.out.println("Query::"+flightQuery);
                while (resultSet.next()){
                        flightNum1 = resultSet.getInt("no1");
                        flightNum2 = resultSet.getInt("no2");
                        flightNum3 = resultSet.getInt("no3");
                        weekdays1 = resultSet.getString("w1");
                        weekdays2 = resultSet.getString("w2");
                        weekdays3 = resultSet.getString("w3");
                        sourceCode = resultSet.getString("d1");
                        interCode = resultSet.getString("i1");
                        interCode1 = resultSet.getString("i2");
                        arrCode = resultSet.getString("a1"); 
           
                        fareInfoBean = new FareInfoBean();
                        fareInfoBean.setFlightNum1(flightNum1);
                        fareInfoBean.setFlightNum2(flightNum2);
                        fareInfoBean.setFlightNum3(flightNum3);
                        fareInfoBean.setWeekdays1(weekdays1);
                        fareInfoBean.setWeekdays2(weekdays2);
                        fareInfoBean.setWeekdays3(weekdays3);
                        fareInfoBean.setDepCode(sourceCode);
                        fareInfoBean.setInterCode(interCode);
                        fareInfoBean.setInterCode1(interCode1);
                        fareInfoBean.setArrCode(arrAirCode);
          
                        flightData.add(fareInfoBean);
                    }
                    session.setAttribute("flightData",flightData);
                    response.sendRedirect("SearchInfo2.jsp");    
                }
            }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchFlights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchFlights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
