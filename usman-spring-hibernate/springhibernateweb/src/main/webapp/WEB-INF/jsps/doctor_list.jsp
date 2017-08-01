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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medical Life</title>
        <script type="text/javascript">
            function openNewDoctor()
            {
                window.location.href = "new";
            }
        </script>
    </head>
    <body>
        <br/>
        <div align="center"><input type="button" value="Add Doctor" onclick="openNewDoctor();"/></div>
        <h1>Display Doctor List</h1>


        <table border="1" cellspacing="0">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Sex</td>
                <td>Degree</td>
                <td>Profession</td>
                <td>Experience</td>
                <td>Address</td>
                <td>DOB</td>
                <td>Description</td>
                <td>Actions</td>
            </tr>


            <c:choose>
                <c:when test="${not empty doctors}">
                    <c:forEach var="docs" items="${doctors}">
                        <tr>
                            <td>${docs.moduleId}</td>
                            <td>${docs.name}</td>
                            <td>${docs.sex}</td>
                            <td>${docs.degree}</td>
                            <td>${docs.profession}</td>
                            <td>${docs.experience}</td>
                            <td>${docs.address}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${docs.dateOfBirth}" /></td>
                            <td>${docs.description}</td>
                            <td>
                                &nbsp;<a href="edit?docId=${docs.moduleId}" alt="Edit"><img src="../../../app/images/edit.png"/></a>&nbsp;&nbsp;
                                &nbsp;<a href="delete?docId=${docs.moduleId}" alt="Delete"><img src="../../../app/images/delete.gif"/></a>&nbsp;
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

        </table>

    </body>
</html>
