<%-- 
    Document   : CustInfo
    Created on : Mar 28, 2015, 4:41:58 PM
    Author     : Shraddha
--%>

<%@page import="fare.FareInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passenger Information</title>
        <style>
            body {
                background-color:  #81C3E4;
            }
        </style>
    </head>
    <body>
        <%
                ArrayList custName = (ArrayList) session.getAttribute("custData");
                if(custName.isEmpty()){
        %>
    <center><font color="black" size="6">Sorry! No Data Found!</font></center>
        <%
                }else{
        %>
    <center><u><font color="black" size="6">Passenger Information</font></u><br><br><br>
        <table border="1" cellspacing="5">
            <tr>
                <td style="color:white">Flight Number</td>
                <td style="color:white">Date</td>
                <td style="color:white">Seat Number</td>
                <td style="color:white">Customer Name</td>
            </tr>
            <%
                for(int i = 0;i < custName.size();i++)
                {
            %>
            <tr>
                <td> <% out.print(" "+((FareInfoBean) custName.get(i)).getFlightNum());%></td>
                <td> <% out.print(" "+((FareInfoBean) custName.get(i)).getDate());%></td>
                <td> <% out.print(" "+((FareInfoBean) custName.get(i)).getSeatNum());%></td>
                <td> <% out.print(" "+((FareInfoBean) custName.get(i)).getCustName());%></td>
            </tr>
            <%
                }
             }
            %>
    </body>
</html>
