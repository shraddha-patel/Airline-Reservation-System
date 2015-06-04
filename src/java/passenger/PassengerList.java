/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passenger;

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
@WebServlet(name = "PassengerList", urlPatterns = {"/PassengerList"})
public class PassengerList extends HttpServlet {

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
            RequestDispatcher requestDispatcher = null;
            String flightNumber = request.getParameter("fNumber");
            String date = request.getParameter("date")==null?"":request.getParameter("date");
            int flightNum;
            if (flightNumber != null)
                flightNum = Integer.parseInt(flightNumber);
            else{
                flightNum = 0;
                requestDispatcher = request.getRequestDispatcher("/Error.jsp");
                requestDispatcher.forward(request, response);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?zeroDateTimeBehavior=convertToNull","root","connect");
            Statement stmt = con.createStatement();
            String fareQuery = "select s.customer_name,s.date,s.seat_number from seat_reservation s, flight_instance f where f.flight_number = s.flight_number and f.flight_number = " + flightNum
                                +" and f.date like '%"+ date +"'";
            String custName = null;
            String seatNum = null;
            System.out.println("Query::"+fareQuery);
            ResultSet resultSet = stmt.executeQuery(fareQuery);
            FareInfoBean fareInfoBean = null;
            ArrayList<FareInfoBean> custData = new ArrayList<FareInfoBean>();
            while(resultSet.next()){
                custName = resultSet.getString("customer_name");
                date = resultSet.getString("date");
                seatNum = resultSet.getString("seat_number");
                fareInfoBean = new FareInfoBean();
                fareInfoBean.setCustName(custName);
                fareInfoBean.setFlightNum(flightNum);
                fareInfoBean.setDate(date);
                fareInfoBean.setSeatNum(seatNum);
                custData.add(fareInfoBean);
            }
            session.setAttribute("custData",custData);
            response.sendRedirect("CustInfo.jsp");        
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
            Logger.getLogger(PassengerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PassengerList.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PassengerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PassengerList.class.getName()).log(Level.SEVERE, null, ex);
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
