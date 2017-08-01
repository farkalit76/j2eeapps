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
        <title>Inventory System</title>
    </head>
    <body>
        <h1>Display Sale List</h1>

        <table border="1" cellspacing="0">
            <tr>
                <td>Sale ID</td>
                <td>Prod ID</td>
                <td>Prod Name</td>
                <td>Quantity</td>
                <td>Amount</td>
                <td>Customer ID</td>
                <td>Customer name</td>
                <td>Created Date</td>
                <td>Edit</td>
            </tr>

            <c:choose>
                <c:when test="${not empty sales}">
                    <c:forEach var="sale" items="${sales}">
                        <tr>
                            <td>${sale.moduleId}</td>
                            <td>${sale.prodId}</td>
                            <td>${sale.prodName}</td>
                            <td>${sale.quantity}</td>
                            <td>${sale.amount}</td>
                            <td>${sale.custId}</td>
                            <td>${sale.custName}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss a" value="${sale.createdDate.time}" /></td>
                            <td>
                                &nbsp;<a href="edit?paysId=${sale.moduleId}" ><img src="../../../app/images/edit.png" alt="Edit" title="Edit"/></a>&nbsp;&nbsp;
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
