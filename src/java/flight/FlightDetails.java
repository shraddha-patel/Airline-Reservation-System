/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight;

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
@WebServlet(name = "FlightDetails", urlPatterns = {"/FlightDetails"})
public class FlightDetails extends HttpServlet {

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
            String passName = request.getParameter("pName");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?zeroDateTimeBehavior=convertToNull","root","connect");
            Statement stmt = con.createStatement();
      
            String flightQuery = "select s.customer_name, f.flight_number, f.date , f.departure_time, f.arrival_time, s.seat_number from flight_instance f , seat_reservation s where f.flight_number = s.flight_number and s.customer_name like '%" + passName+"%'";
            System.out.println("Query::"+flightQuery);
            ResultSet resultSet = stmt.executeQuery(flightQuery);
            FareInfoBean fareInfoBean = null;
            String custName = null;
            int flightNum = 0;
            String date = null;
            String deptTime = null;
            String arrTime = null;
            String seatNum = null;
            ArrayList<FareInfoBean> flightData = new ArrayList<FareInfoBean>();
            while(resultSet.next()){
                custName = resultSet.getString("customer_name");
                flightNum = resultSet.getInt("flight_number");
                date = resultSet.getString("date");
                deptTime = resultSet.getString("departure_time");
                arrTime = resultSet.getString("arrival_time");
                seatNum = resultSet.getString("seat_number");
                fareInfoBean = new FareInfoBean();
                fareInfoBean.setCustName(custName);
                fareInfoBean.setFlightNum(flightNum);
                fareInfoBean.setDate(date);
                fareInfoBean.setDeptTime(deptTime);
                fareInfoBean.setArrTime(arrTime);
                fareInfoBean.setSeatNum(seatNum);
                flightData.add(fareInfoBean);
            }
            session.setAttribute("flightData",flightData);
            response.sendRedirect("FlightInfo.jsp");  
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
            Logger.getLogger(FlightDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FlightDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FlightDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FlightDetails.class.getName()).log(Level.SEVERE, null, ex);
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
