<%-- 
    Document   : Fare
    Created on : Mar 28, 2015, 10:48:58 AM
    Author     : Shraddha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fare Information</title>
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
                return true;
            }
        </script>
    </head>
    <body>
        <font color="black" size="8"><u>Get Fare Information</u></font><br><br><br>
        <form action="FairInfo" method="get">
            <table border="0">
               <tr>
                   <td>
                        <font color="blue"/>Flight Number <font color="red" size="4">*</font>:
                   </td>
                   <td>
                       <input name="fNumber" type="text" id="fNumber" /><br>
                   </td>
               </tr>
               <tr>
                   <td></td>
                   <td></td>
               </tr>
               <tr>
                   <td></td><td>
                       <input name="FairInfo" type="submit" value="Get Fare Information" style="width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue" onclick="return validate();"/>
                   </td>
               </tr>
        </form>
    </body>
</html>
