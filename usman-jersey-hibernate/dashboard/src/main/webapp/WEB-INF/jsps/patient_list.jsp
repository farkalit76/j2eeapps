<%-- 
    Document   : patient_list
    Created on : 22 Oct, 2015, 4:06:56 PM
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
            function openNewPatient()
            {
                window.location.href = "new";
            }
        </script>
    </head>
    <body>
        <table border="1" width="100%" cellspacing="0" height="800px">
            <tr>
                <td width="22%" valign="top">
                    <!-- display patient search -->
                    <%@include file="patient_search.jsp" %>
                </td>
                <td valign="top">
                    <!-- display patient lists-->
                    <div align="center" valign="top"><input type="button" value="Add Patient" onclick="openNewPatient();"/></div>
                    <h3>Display Patient List</h3>

                    <table border="1" cellspacing="0" valign="top">
                        <tr>
                            <td>&nbsp;</td>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Sex</td>
                            <td>Age</td>
                            <td>Address</td>
                            <td>Phone</td>
                            <td>Email</td>
                            <td>Description</td>
                            <td>Actions</td>
                        </tr>

                        <c:choose>
                            <c:when test="${not empty patients}">
                                <c:forEach var="pats" items="${patients}">
                                    <tr>
                                        <td>&nbsp;<button><a href="../payment/new?patsId=${pats.moduleId}" alt="Payment" title="Payment">Pay</a></button></td>
                                        <td>${pats.moduleId}</td>
                                        <td>${pats.name}</td>
                                        <td>${pats.sex}</td>
                                        <td>${pats.age}</td>
                                        <td>${pats.address}</td>
                                        <td>${pats.phone}</td>
                                        <td>${pats.email}</td>
                                        <td>${pats.description}</td>
                                        <td>
                                            &nbsp;<a href="edit?patsId=${pats.moduleId}" ><img src="../../../app/images/edit.png" alt="Edit" title="Edit"/></a>&nbsp;&nbsp;
                                            &nbsp;<a href="delete?patsId=${pats.moduleId}" ><img src="../../../app/images/delete.gif" alt="Delete" title="Delete"/></a>&nbsp;
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr >
                                    <td colspan="10" width="800px">No Result found for your search.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
