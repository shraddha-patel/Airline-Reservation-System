<%-- 
    Document   : FlightInfo
    Created on : Mar 28, 2015, 6:04:47 PM
    Author     : Shraddha
--%>

<%@page import="fare.FareInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Information</title>
        <style>
            body {
                background-color:  #81C3E4;
            }
        </style>
    </head>
    <body>
        <%
                ArrayList fareData = (ArrayList)session.getAttribute("flightData"); 
                if(fareData.isEmpty()){
        %>
    <center><font color="black" size="6">Sorry! No Data Found!</font></center>
        <%
                }else{
        %>
    <center><u><font color="black" size="6">Flight Information</font></u><br><br><br>
        <table border="1" cellspacing="5">
            <tr>
                <td style="color:white">Customer Name</td>
                <td style="color:white">Flight Number</td>
                <td style="color:white">Date</td>
                <td style="color:white">Departure Time</td>
                <td style="color:white">Arrival Time</td>
                <td style="color:white">Seat Number</td>
            </tr>
            <%         
                for(int i = 0;i < fareData.size();i++)
                {
            %>
            <tr>
                <td> <% out.print(" "+((FareInfoBean) fareData.get(i)).getCustName());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getFlightNum());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getDate());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getDeptTime());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getArrTime());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getSeatNum());%></td>
            <%
                }
              }
            %>
            </tr>
        </table>
    </body>
</html>
