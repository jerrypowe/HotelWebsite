<%-- 
    Document   : read
    Created on : Oct 22, 2024, 11:39:40 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
//            document.cookie = "1P_JAR=akjdsbJKHdjhbk";
//            document.cookie = "CONSENT=YES+IN.en+20170903-09-0";

            function displayCookies() {

                let displayCookies = document.getElementById("display");
                displayCookies.innerHTML = document.cookie;
            }

            function deleteCookies() {
                sessionStorage.clear();
                let allCookies = document.cookie.split(';');


                for (let i = 0; i < allCookies.length; i++)
                    document.cookie = allCookies[i] + "=;expires="
                            + new Date(0).toUTCString();

                displayCookies.innerHTML = document.cookie;
                

            }
            function redirectToJSP(nameData) {
                window.location.href = nameData;
            }
           
        </script>
    </head>
    <body>
        <h1>INFORMATION OF CUSTOMER</h1>
        <button  onclick=" redirectToJSP('index.jsp'); deleteCookies()">LOGOUT</button>
         <button  onclick=" redirectToJSP('search.jsp')">Search</button>
         <button onclick="redirectToJSP('/RoomManageServlet')">Room Mange</button>
        <br></br>

        <table border="1" cellpadding="0" cellspacing="0">


            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>PhoneNumber</th>
                <th>Email</th>
                <th>Password</th>
                <th>Date of Birth</th>
           
            </tr>

            <c:forEach items="${dataread}" var="cus">
                <tr>
                    <td>${cus.ID}</td>
                    <td>${cus.name}</td>
                    <td>${cus.address}</td>
                    <td>${cus.phoneNumber}</td>
                    <td>${cus.email}</td>
                    <td>${cus.password}</td>
                    <td>${cus.age}</td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
