<%-- 
    Document   : Search
    Created on : Mar 28, 2015, 10:39:13 AM
    Author     : Shraddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Flights</title>
        <style>
            body {
                background-image: url("Airplae2.jpg");
                background-repeat: no-repeat;
                background-position: center; 
            }
        </style>
        <script>
        function validate(){
                var DeptAirCode = document.getElementById("DeptAirCode").value;
                var ArrAirCode = document.getElementById("ArrAirCode").value;
                
                if (DeptAirCode == ""){
                    alert('Please Enter Departure Airport Code');
                    return false;
                }
                
                if(ArrAirCode == ""){
                    alert('Please Enter Arrival Airport Code');
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
    <font color="black" size="8"><u>Search Flights</u></font><br><br><br>
        <form action="SearchFlights" method="get">
            <table border="0">
               <tr>
                    <td>
                        <font color="blue"/>Departure Airport Code <font color="red" size="4">*</font>:
                    </td>
                    <td>
                        <input name="DeptAirCode" id="DeptAirCode" type="text" />
                    </td>
               </tr>
               <tr>
                    <td>
                        <font color="blue"/>Arrival Airport Code <font color="red" size="4">*</font>:
                    </td>
                    <td>
                        <input name="ArrAirCode" id="ArrAirCode" type="text" />
                    </td>
               </tr>
               <tr></tr>
               <tr></tr>
               <tr>
                   <td>
                       <font color="blue"/><input type="radio" name="type" value="Nonstop">Nonstop &nbsp;
                       <font color="blue"/><input type="radio" name="type" value="1-stop">1-stop &nbsp;
                       <font color="blue"/><input type="radio" name="type" value="2-stop">2-stop &nbsp;
                   </td>
                </tr>
               <tr>
                   <td></td>
                    <td>
                        <input name="SearchFlights" type="submit" value="Search Flights" style="width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue" onclick=" return validate()" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
