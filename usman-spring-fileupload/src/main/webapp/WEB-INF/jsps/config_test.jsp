<%-- 
    Document   : config_test
    Created on : 13 Oct, 2015, 12:02:05 PM
    Author     : 72010995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Context and Config Values</h1>
        
         <c:forEach items="${contextList}" var="vals">
            <tr>
                <td>${vals}</td>
            </tr>
        </c:forEach>
    </body>
</html>
