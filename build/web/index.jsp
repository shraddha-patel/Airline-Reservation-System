<%-- 
    Document   : index
    Created on : Mar 27, 2015, 1:15:41 PM
    Author     : Shraddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Airline Reservation System</title>
        <style>
            body {
                background-image: url("Airplae2.jpg");
                background-repeat: no-repeat;
                background-position: center; 
            }
        </style>
    </head>
    <body>
    <font color="black" size="8"><u>Airline Reservation System</u></font><br><br><br>
    <table border="0" align="left" cellspacing="20">
        <tr>
            <td>
                <form action="Search.jsp" method="get">
                     <input name="Search" type="submit" value="Search Flights" style="width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue">
                 </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="Seats.jsp" method="get">
                    <center>
                        <input name="Seats" type="submit" value="Seat Availability" style="width: 150px; height: 60px;background: #F2E527; border-radius: 15px; color: blue">
                    </center>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="Fare.jsp" method="get">
                    <center>
                        <input name="Fare" type="submit" value="Fare Information" style="width: 150px; height: 60px;background: #F2E527; border-radius: 15px; color: blue">
                    </center>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="Passenger.jsp" method="get">
                    <center>
                        <input name="Passenger" type="submit" value="Passenger Information" style="width: 150px; height: 60px;background: #F2E527; border-radius: 15px; color: blue">
                    </center>
                </form>
            </td>
        </tr>
    </table>
   </body>
</html>
