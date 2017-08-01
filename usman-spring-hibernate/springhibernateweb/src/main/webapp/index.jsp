<%-- 
    Document   : index
    Created on : 23 Oct, 2015, 10:43:42 PM
    Author     : 72010995
--%>
<%
    String contextName = request.getContextPath().toString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hospital World!</h1>
         <li>User List: <a href="<%= contextName %>/app/views/user/show">User</a></li>
        <li>Doctor List: <a href="<%= contextName %>/app/views/doctor/show">Doctor</a></li>
    </body>
</html>
