<%-- 
    Document   : FairInfo
    Created on : Mar 28, 2015, 11:52:29 AM
    Author     : Shraddha
--%>

<%@page import="fare.FareInfoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fare Information</title>
         <style>
            body {
                background-color:  #81C3E4;
            }
        </style>
    </head>
    <body>
        <%
                ArrayList fareData = (ArrayList)session.getAttribute("fareData"); 
                if(fareData.isEmpty()){
        %>
    <center><font color="black" size="6">Sorry! No Data Found!</font></center>
        <%
                }else{
        %>
    <center><u><font color="black" size="6">Fare Information</font></u><br><br><br>
        <table border="1" cellspacing="5">
            <tr>
                <td style="color:white">Flight Number</td>
                <td style="color:white">Fare Code</td>
                <td style="color:white">Amount</td>
                <td style="color:white">Restrictions</td>
            </tr>
            <%
                for(int i = 0;i < fareData.size();i++)
                {
            %>
            <tr>
                <td style="border: 1px solid;"> <% out.print(" "+((FareInfoBean) fareData.get(i)).getFlightNum());%></td>
                <td style="border: 1px solid;"><% out.print(" "+((FareInfoBean) fareData.get(i)).getFareCode());%></td>
                <td style="border: 1px solid;"><% out.print(" "+((FareInfoBean) fareData.get(i)).getAmount());%></td>
                <td style="border: 1px solid;"><% out.print(" "+((FareInfoBean) fareData.get(i)).getRestriction());%></td>
            <%
                }
              }
            %>
            </tr>
        </table>
    </body>
</html>
