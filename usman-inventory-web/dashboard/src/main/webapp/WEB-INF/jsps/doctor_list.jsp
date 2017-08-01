<%-- 
    Document   : doctor_list
    Created on : 22 Oct, 2015, 1:35:35 PM
    Author     : 72010995
--%>

<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        
        <link href="../../../app/sorting/dataTables.bootstrap.min.css" rel="stylesheet">   
	<script src="../../../app/sorting/jquery.js"></script>
	<link rel="stylesheet" href="../../../app/sorting/jquery.dataTables.min.css"></style>
	<script type="text/javascript" src="../../../app/sorting/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../../../app/sorting/dataTables.bootstrap.min.js"></script>
        
        <title>Medical Life</title>
        <script type="text/javascript">
            function openNewDoctor()
            {
                window.location.href = "new";
            }
        </script>
        <style>
           docTable tr#even{height: 15px}

        </style>
    </head>
    <body>
        <br/>
        <div align="center"><input type="button" value="Add Doctor" onclick="openNewDoctor();"/></div>
        <h1>Display Doctor List</h1>


        <table id="docTable" class="table table-striped" border="1" cellspacing="0" width="95%">
            <thead>
            <tr bgcolor="#ccddff">
                <th>ID</th>
                <th>Name</th>
                <th>Sex</th>
                <th>Degree</th>
                <th>Profession</th>
                <th>Experience</th>
                <th width="30%">Address</th>
                <th width="10%">DOB</th>
                <th width="20%">Description</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty doctors}">
                    <c:forEach var="docs" items="${doctors}">
                        <tr >
                            <td>${docs.moduleId}</td>
                            <td>${docs.name}</td>
                            <td>${docs.sex}</td>
                            <td>${docs.degree}</td>
                            <td>${docs.profession}</td>
                            <td>${docs.experience}</td>
                            <td>${docs.address}</td>
                            <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${docs.dateOfBirth}" /></td>
                            <td>${docs.description}</td>
                            <td>
                                &nbsp;<a href="edit?docId=${docs.moduleId}" ><img src="../../../app/images/edit.png" alt="Edit" title="Edit"/></a>&nbsp;&nbsp;
                                &nbsp;<a href="delete?docId=${docs.moduleId}" ><img src="../../../app/images/delete.gif" alt="Delete" title="Delete"/></a>&nbsp;
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
            $('#docTable').dataTable();
        });
    </script>

</html>

