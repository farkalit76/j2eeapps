<%-- 
    Document   : locale_test
    Created on : 13 Oct, 2015, 10:51:19 AM
    Author     : 72010995
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Spring MVC Hello World</title>
</head>
 <!-- Run with following two URLs
  http://localhost:8088/FJavaSpring/app/views/locale/test
 OR
 http://localhost:8088/FJavaSpring/app/views/locale/test?lang=en
 AND
 http://localhost:8088/FJavaSpring/app/views/locale/test?lang=zh_CN
 -->
<body>
    <h2><spring:message code="lbl.page" text="All Employees in System" /></h2>
 
    <table border="1">
        <tr>
            <th><spring:message code="lbl.Id" text="Employee Id" /></th>
            <th><spring:message code="lbl.firstName" text="First Name" /></th>
            <th><spring:message code="lbl.lastName" text="Last Name" /></th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
            </tr>
        </c:forEach>
    </table>
 
</body>
</html>
