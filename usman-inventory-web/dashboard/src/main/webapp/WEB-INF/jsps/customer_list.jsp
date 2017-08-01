<%-- 
    Document   : customer_list
    Author     : 72010995
--%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>
<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inventory Page</title>
        <link href="../../../app/sorting/dataTables.bootstrap.min.css" rel="stylesheet">   
	<script src="../../../app/sorting/jquery.js"></script>
	<link rel="stylesheet" href="../../../app/sorting/jquery.dataTables.min.css"></style>
	<script type="text/javascript" src="../../../app/sorting/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../../../app/sorting/dataTables.bootstrap.min.js"></script>
        
        <script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
    </head>
    <body>
        <br/>
        <div align="center"></div>
        <h3>Display Customer List <input type="button" value="Add Customer" onclick="openNewCustomer();"/></h3>


        <table id="custTable" class="table table-striped" border="1" cellspacing="0" cellpadding="2" width="99%" >
            <thead>
            <tr bgcolor="#ccddff">
                <th width="5%">ID</th>
                <th width="10%">Name</th>
                <th width="5%">Sex</th>
                <th width="10%">Email</th>
                <th width="10%">Profession</th>
                <th width="5%">Experience</th>
                <th width="15%">Address</th>
                <th width="10%">D.O.B.</th>
                <th width="20%">Description</th>
                <th width="5%">Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty customers}">
                    <c:forEach var="custs" items="${customers}">
                        <tr>
                            <td>${custs.moduleId}</td>
                            <td>${custs.name}</td>
                            <td>${custs.sex}</td>
                            <td>${custs.degree}</td>
                            <td>${custs.profession}</td>
                            <td>${custs.experience}</td>
                            <td>${custs.address}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${custs.dateOfBirth}" /></td>
                            <td>${custs.description}</td>
                            <td>
                                &nbsp;&nbsp;&nbsp;<a href="edit?custId=${custs.moduleId}" ><img src="../../../app/images/edit.png" alt="Edit" title="Edit"/></a>&nbsp;&nbsp;
<!--                                &nbsp;<a href="delete?custId=${custs.moduleId}" onclick="return confirmCsutomerDelete();"><img src="../../../app/images/delete.gif" alt="Delete" title="Delete"/></a>&nbsp;-->
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr >
                        <td colspan="11" width="800px">No Record Found into the database.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>

    </body>
     <script>
        $(document).ready(function(){
            $('#custTable').dataTable();
        });
    </script>
    
</html>
