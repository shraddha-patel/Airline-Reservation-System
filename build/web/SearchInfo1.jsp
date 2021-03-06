<%-- 
    Document   : SearchInfo
    Created on : Mar 28, 2015, 4:14:33 PM
    Author     : Shraddha
--%>

<%@page import="fare.FareInfoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
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
                <td style="color:white">Departure Airport Code</td>
                
                <td style="color:white">Arrival Airport Code</td>
                
                <td style="color:white">Flight Number</td>
                
                <td style="color:white">Weekdays</td>
            </tr>
            <%
                for(int i = 0;i < fareData.size();i++)
                {
            %>
            <tr>
                <td> <% out.print(" "+((FareInfoBean) fareData.get(i)).getDepCode());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getArrCode());%></td>
                <td> <% out.print(" "+((FareInfoBean) fareData.get(i)).getFlightNum());%></td>
                <td><% out.print(" "+((FareInfoBean) fareData.get(i)).getWeekdays());%></td>
                 <%
                    }
                }
                 %>
            </tr>
        </table>
        </center>
    </body>
</html>
