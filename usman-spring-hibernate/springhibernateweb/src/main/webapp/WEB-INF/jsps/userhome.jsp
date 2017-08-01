<%-- 
    Document   : userhome
    Created on : 23 Oct, 2015, 11:01:27 PM
    Author     : 72010995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <table border="1">
                <th>No</th>
                <th>Username</th>
                <th>Created By</th>
                <th>Created Date</th>
                <c:forEach var="user" items="${userList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${user.userName}</td>
                        <td>${user.createdBy}</td>
                        <td>${user.createdDate.time}</td>
                    </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
