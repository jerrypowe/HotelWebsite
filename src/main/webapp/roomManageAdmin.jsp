<%-- 
    Document   : roomManageAdmin
    Created on : Oct 25, 2024, 12:38:33 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <style>
            .button-link {
                display: inline-block;
                padding: 10px 15px;
                font-size: 16px;
                color: white;
                background-color: #007BFF; /* Màu nền */
                text-align: center;
                text-decoration: none; /* Ẩn gạch chân */
                border-radius: 5px; /* Bo góc */
                border: none;
                cursor: pointer; /* Con trỏ khi di chuột */
            }

            .button-link:hover {
                background-color: #0056b3; /* Màu nền khi hover */
            }
        </style>
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
        <h2>INFOMATION OF ROOM' STATUS</h2>
          <button  onclick=" redirectToJSP('index.jsp'); deleteCookies()">LOGOUT</button>
         <button  onclick=" redirectToJSP('/Read')">Read</button>
<!--         <button onclick="redirectToJSP('Servlet')">Room Mange</button> comment 
         -->
         <br></br>
        <table border="1">
            <thead>
                <tr>
                    <th>Room_Code</th>
                    <th>Room_ID</th>
                    <th>Available</th>
                    <th>Booked</th>
                    <th>Occupied</th>
                    <th>Choose</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dataRoom}" var="room">
                    <tr>
                        <td>${room.code}</td>
                        <td>${room.ID}</td>

                        <td>
                            <input type="radio" name="avai_${room.code}" value="ON" disabled <c:if test="${room.available}">checked="checked" disabled</c:if> />
                            </td>

                            <td>
                                <input type="radio" name="booked_${room.code}" value="ON"disabled  <c:if test="${room.booked}">checked="checked" disabled</c:if> />
                            </td>

                            <td>
                                <input type="radio" name="occup_${room.code}" value="ON" disabled <c:if test="${room.occupied}">checked="checked" disabled</c:if>/>
                            </td>

                            <td> 
<!--                                <form action="RoomManageServlet" method="post">
                                    <input type="hidden" name="roomCode" value="${room.code}" />
                                <input type="submit" value="Confirm" />-->
                               <a href="UpdateRoom?RoomCode=${room.code}" class="button-link">Update</a>
                            </form>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br></br>

    </body>
</html>
