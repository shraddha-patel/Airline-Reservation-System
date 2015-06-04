<%-- 
    Document   : Seats
    Created on : Mar 28, 2015, 10:44:01 AM
    Author     : Shraddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Seats</title>
         <style>
            body {
                background-image: url("Airplae2.jpg");
                background-repeat: no-repeat;
                background-position: center; 
            }
        </style>
        <script>
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
                if(date == ""){
                    alert("Please Enter Date  "  );
                    return false;
                }
                if(date != "" && !date.match(re)) {
                    alert("Invalid date format : " + date );
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <font color="black" size="8"><u>Search Available Seats</u></font><br><br><br>
        <form action="SearchSeats" method="get">
             <table border="0">
               <tr>
                   <td>
                       <font color="blue"/>Flight Number <font color="red" size="4">*</font>:
                   </td>
                   <td>
                       <input name="fNumber" id="fNumber" type="text" />
                   </td>
               </tr>
               <tr>
                   <td>
                      <font color="blue"/> Date <font color="red" size="4">*</font>:
                   </td>
                   <td>
                       <input name="date" id="dt" type="text" />
                   </td>
                   <td>
                       <font color="blue"/>(yyyy-mm-dd)
                   </td>
               </tr>
               <tr>
                   <TD></TD>
                   <td>
                       <input name="SearchSeats" type="submit" value="Search Available Seats" style="width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue" onclick=" return validate()"/>
                   </td>
               </tr>
        </form>
    </body>
</html>
