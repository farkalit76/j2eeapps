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
        <title>Medical Line</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript">

            function  updateDoctor()
            {
                form = document.getElementById('doctor');
                form.action = 'update';
                form.submit();
            }
            function resetDoctor()
            {
                document.forms[0].name.value = '';
                document.forms[0].degree.value = '';
                document.forms[0].profession.value = '';
                document.forms[0].experience.value = '';
                document.forms[0].address.value = '';
                document.forms[0].dateOfBirth.value = '';
            }
        </script>
    </head>
    <body>
        <h1>Create New Doctor</h1>

        <form:form action="create" method="post"  modelAttribute="doctor" >
            <form:hidden path="moduleId" />
            <table width="60%" >
                <tr >
                    <td width="20%">Name:</td><td width="80%"><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Degree</td><td><form:input path="degree" /></td>
                </tr>
                <tr>
                    <td>Profession:</td><td><form:input path="profession" /></td>
                </tr>
                <tr>
                    <td>Experience:</td><td><form:input path="experience" size="12" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>Address:</td><td><form:input path="address" /></td>
                </tr>
                <tr>
                    <td>Date Of Birth:</td><td><form:input path="dob" size="12" maxlength="10"/>
                        <br/>&nbsp;<font size="1.8"><b>Insert date format as YYYY-MM-DD</b></font></td>
                </tr>
                <tr>
                    <td>Sex:</td><td>
                        <form:select path="sex">
                            <c:forEach var="sex" items="${sexdata}">
                                <c:choose>
                                    <c:when test="${not empty doctor.sex && (doctor.sex eq fee.key)}">
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
                            <c:when test="${not empty action && (action eq 'EDIT')}">
                                <input type="submit"  value="Update" onclick="updateDoctor();"/>&nbsp;
                            </c:when>
                            <c:otherwise>
                                <input type="submit"  value="Submit" />&nbsp;
                            </c:otherwise>
                        </c:choose>
                        <input type="button"  value="Reset" onclick="resetDoctor();"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
