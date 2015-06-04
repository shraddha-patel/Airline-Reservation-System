<%-- 
    Document   : Passenger
    Created on : Mar 28, 2015, 10:51:45 AM
    Author     : Shraddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passenger Information</title>
         <style>
            body {
                background-image: url("Airplae2.jpg");
                background-repeat: no-repeat;
                background-position: center; 
            }
        </style>
        <script type="text/javascript">
            function validate(){
                var fNum = document.getElementById("fNumber").value;
                var date = document.getElementById("dt").value;
                re = /^\d{4}\-\d{1,2}\-\d{1,2}$/; 
                if (fNum == null || fNum == ""){
                    alert('Please Enter Flight Number');
                    return false;
                }
                if(isNaN(fNum)){
                    alert('Please Enter a Valid Flight Number');       
                    return false;
                } 
                if(fNum != null || fNum != ""){
                    if(fNum.toString().length > 4){
                        alert('Please Enter a Valid Flight Number upto length 4');       
                        return false;
                    }
                }
                if(date != "" && !date.match(re)) {
                    alert("Invalid date format : " + date );
                    return false;
                }
                return true;
            }
            function flightValidate(){
                var pName = document.getElementById("pName").value;
                if(pName == ""){
                    alert("Please Enter Passenger Name");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <font color="black" size="8"><u>Search Passenger List</u></font><br><br><br>
        <form action="PassengerList" method="get">
            <table border="0">
                <tr>
                    <td>
                       <font color="blue"/> Flight Number <font color="red" size="4">*</font>:
                    </td> 
                    <td>
                        <input name="fNumber" id="fNumber" type="text" />
                    </td>
                </tr>
                <tr>
                    <td>
                       <font color="blue"/> Date :
                    </td> 
                    <td>
                        <input name="date" id="dt" type="text" />
                    </td>
                    <td>
                      <font color="blue"/> (yyyy-mm-dd)
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input name="GetList" type="submit" value="Get Passenger List" style="width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue" onclick="  return validate();">
                    </td>
                </tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
            </table>
            
        </form>
        <table border="0">
    
    <font color="black" size="8"><u>Search Flight Information</u></font><br><br><br>
    <tr><td></td></tr>
    <tr><td></td></tr>
        <form action="FlightDetails" method="get">
            
                <tr>
                    <td>
                       <font color="blue"/> Passenger Name <font color="red" size="4">*</font>: 
                    </td>
                    <td>
                        <input name="pName" id="pName" type="text" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input name="FlightDetails" type="submit" value="Get Flight Information" style="width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue" onclick="return flightValidate()">
                    </td>
                </tr>
        </form> 
        </table>
    </body>
</html>
