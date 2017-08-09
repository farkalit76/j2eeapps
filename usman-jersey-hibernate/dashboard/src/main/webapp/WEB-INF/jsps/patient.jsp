<%-- 
    Document   : doctor
    Created on : 22 Oct, 2015, 10:46:19 AM
    Author     : 72010995
--%>

<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Medical Life</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script type="text/javascript" src="../../../app/jscript/medical.js" ></script>
    </head>
    <body>

    <h1>Create New Patient</h1>
        <form:form action="create" method="post"  modelAttribute="patient" >
            <form:hidden path="moduleId" />
            <table>
                <tr>
                    <td>Name:</td><td><form:input path="name" /></td>
                </tr>   
                <tr>
                    <td>Age:</td><td><form:input path="age" size="4" maxlength="4" /></td>
                </tr>
                <tr>
                    <td>Address:</td><td><form:input path="address" /></td>
                </tr>
                <tr>
                    <td>Phone:</td><td><form:input path="phone" /></td>
                </tr>
                <tr>
                    <td>Email</td><td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Sex:</td><td>
                        <form:select path="sex">
                            <c:forEach var="sex" items="${sexdata}">
                                <c:choose>
                                    <c:when test="${not empty patient.sex && (patient.sex eq fee.key)}">
                                        <option value="${sex.key}" selected="true">${sex.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${sex.key}">${sex.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr >
                    <td>Description:</td><td><form:input path="description" size="40" maxlength="250"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>
                         <c:choose>
                            <c:when test="${(not empty action) && (action eq 'EDITS')}">
                                <input type="submit"  value="Update" onclick="updatePatient();"/>&nbsp;
                            </c:when>
                            <c:otherwise>
                                <input type="submit"  value="Submit" />&nbsp;
                            </c:otherwise>
                        </c:choose>
                        <input type="button" value="Reset" onclick="resetPatient();"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
