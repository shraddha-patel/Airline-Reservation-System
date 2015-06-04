<%-- 
    Document   : SeatInfo
    Created on : Mar 28, 2015, 3:38:06 PM
    Author     : Shraddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seat Information</title>
        <style>
            body {
                background-color:  #81C3E4;
            }
        </style>
    </head>
    <body>
    <center><u><font color="black" size="6">Seat Information</font></u><br><br><br>
        <br><br>
        <table border="1" cellspacing="5">
            <tr>
                <td style="color:white">Flight Number</td>
                <td style="color:white">Date</td>
                <td style="color:white">Available Seats</td>
            </tr>
            <%
                int avail_seats = (Integer) session.getAttribute("avail_seats"); 
                String fNumber = (String) session.getAttribute("flightNumber"); 
                String date = (String) session.getAttribute("date"); 
            %>
            <tr>
                <td> <%= fNumber %></td>
                <td> <%= date %></td>
                <td> <%= avail_seats %></td>
            </tr>
        </table>
        </center>
    </body>
</html>
