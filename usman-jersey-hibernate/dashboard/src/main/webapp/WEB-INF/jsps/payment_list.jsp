<%-- 
    Document   : payment_list
    Created on : 22 Oct, 2015, 8:22:14 PM
    Author     : 72010995
--%>

<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medical Life</title>
    </head>
    <body>
        <h1>Display Payment List!</h1>

        <table border="1" cellspacing="0">
            <tr>
                <td>Pay ID</td>
                <td>Patient ID</td>
                <td>Fee Type</td>
                <td>Amount</td>
                <td>Department</td>
                <td>Doctor</td>
                <td>Description</td>
                <td>Created By</td>
                <td>Created Date</td>
                <td>Edit</td>
            </tr>

            <c:choose>
                <c:when test="${not empty payments}">
                    <c:forEach var="pays" items="${payments}">
                        <tr>
                            <td>${pays.moduleId}</td>
                            <td>${pays.patientId}</td>
                            <td>${pays.feeType}</td>
                            <td>${pays.amount}</td>
                            <td>${pays.department}</td>
                            <td>${pays.doctorId}</td>
                            <td>${pays.description}</td>
                            <td>${pays.createdBy}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss a" value="${pays.createdDate.time}" /></td>
                            <td>
                                &nbsp;<a href="edit?paysId=${pays.moduleId}" ><img src="../../../app/images/edit.png" alt="Edit" title="Edit"/></a>&nbsp;&nbsp;
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr >
                        <td colspan="10" width="800px">No Record Found into the database.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
                    
        </table>

    </body>
</html>
