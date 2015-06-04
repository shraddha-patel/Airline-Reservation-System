/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seats;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "SearchSeats", urlPatterns = {"/SearchSeats"})
public class SearchSeats extends HttpServlet {

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
            String date = request.getParameter("date");
            int flightNum = 0;
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
            String seatQuery = "select ((select a.total_no_of_seats from airplane a, flight_instance f " +
                                        " where a.airplane_id = f.airplane_id and flight_number = " + flightNumber +" and date = '" + date + "') - "+
                                        "(select count(*)  from seat_reservation " +
                                        " where flight_number = " + flightNumber +" and date = '" + date + "') " +
                                ") AS Avail_Seats";
            ResultSet resultSet = stmt.executeQuery(seatQuery);
            System.out.println("Query::"+seatQuery);
            int avail_seats = 0;
   
            while (resultSet.next()){
                avail_seats = resultSet.getInt("Avail_Seats");
            }
            session.setAttribute("avail_seats",avail_seats);
            session.setAttribute("flightNumber",flightNumber);
            session.setAttribute("date",date);
            response.sendRedirect("SeatInfo.jsp");    
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
            Logger.getLogger(SearchSeats.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchSeats.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchSeats.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchSeats.class.getName()).log(Level.SEVERE, null, ex);
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
