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
        <title>Order Page</title>
        <link href="../../../app/sorting/dataTables.bootstrap.min.css" rel="stylesheet">   
	<script src="../../../app/sorting/jquery.js"></script>
	<link rel="stylesheet" href="../../../app/sorting/jquery.dataTables.min.css"></style>
	<script type="text/javascript" src="../../../app/sorting/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../../../app/sorting/dataTables.bootstrap.min.js"></script>
        <style>
           .even{height: 15px; background-color: #eee}
           .odd{height: 15px}
        </style>
    </head>
    <body>
        <table border="1" width="100%" cellspacing="0" height="800px">
            <tr>
                <td width="16%" valign="top">
                    <!-- display order search -->
                    <%@include file="order_search.jsp" %>
                </td>
                <td valign="top">
                    <!-- display order lists-->

                    <h3>Display Order List</h3>

                    <table id="orderTable" class="table table-striped" border="1" cellspacing="0" cellpading="2">
                        <thead>
                        <tr bgcolor="#ccddff">
                            <th width="7%">Order ID</th>
                            <th>Prod. ID</th>
                            <th>Prod. Name</th>
                            <th>Qty.</th>
                            <th>Amount</th>
<!--                            <th>Cust. ID</th>-->
                            <th>Cust. Name</th>
                            <th width="20%">Description</th>
                            <th width="25%">Order Date</th>
                            <th>Disp.</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty orders}">
                                <c:forEach var="ords" items="${orders}">
                                    <tr>
                                        <td>${ords.moduleId}</td>
                                        <td>${ords.prodId}</td>
                                        <td>${ords.prodName}</td>
                                        <td>${ords.quantity}</td>
                                        <td>${ords.amount}</td>
<!--                                        <td>${ords.custId}</td>-->
                                        <td>${ords.custName}</td>
                                        <td>${ords.description}</td>
                                        <td><fmt:formatDate pattern="dd-MMM-yyyy HH:mm a" value="${ords.createdDate.time}" /></td>
                                        <td>${ords.dispatched}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${ords.dispatched eq 'No'}">
                                                    &nbsp;<a href="view?orderId=${ords.moduleId}" ><img src="../../../app/images/dispatch.jpg" style="width:50px;height:20px;" alt="Order View" title="Order View"/></a>&nbsp;&nbsp;
                                                </c:when>
                                                <c:otherwise>
                                                    &nbsp;
                                                </c:otherwise>
                                            </c:choose>
                                            
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
                        </tbody>
                    </table>
                </td>
            </tr>
        </table>
    </body>
    <script>
        $(document).ready(function(){
            $('#orderTable').dataTable();
        });
    </script>
</html>
