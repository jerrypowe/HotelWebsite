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
    </head>
    <body>
        <h1>INFORMATION OF CUSTOMER</h1>
        <table border="1">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>PhoneNumber</th>
                <th>Email</th>
                <th>Password</th>
                <th>Age</th>
                <th>OPTION</th>
            </tr>

            <c:forEach items="${data}" var="cus">
                <tr>
                    <td>${cus.ID}</td>
                    <td>${cus.name}</td>
                    <td>${cus.address}</td>
                    <td>${cus.phoneNumber}</td>
                    <td>${cus.email}</td>
                    <td>${cus.password}</td>
                    <td>${cus.age}</td>
                    <td>
                        <button>UPDATE</button>
                        <button>DELETE</button>
                        
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
