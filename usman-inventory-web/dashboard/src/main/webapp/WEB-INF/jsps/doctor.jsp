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
        <script type="text/javascript" src="../../../app/jscript/medical.js" ></script>
        <!-- add datetime picker -->
        <script language="javascript" type="text/javascript" src="../../../app/jscript/jquery/datetimepicker.js"></script>
        <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }
        </style>
    </head>
    <body>
        <h1>Create New Doctor</h1>

        <form:form action="create" method="post"  modelAttribute="doctor" >
            <form:hidden path="moduleId" />
            <table width="60%" >
                <tr >
                    <td width="20%">Name:</td><td width="80%">
                        <form:input path="name"  size="20" maxlength="50"/>
                        <form:errors path="name" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Degree</td><td>
                        <form:input path="degree"  size="20" maxlength="50"/>
                        <form:errors path="degree" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Profession:</td><td>

                        <form:select path="profession">
                    <option value="">select department..</option>
                    <c:forEach var="dept" items="${departments}">
                        <c:choose>
                            <c:when test="${not empty doctor.profession && (doctor.profession eq dept.key)}">
                                <option value="${dept.key}" selected="true">${dept.value}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${dept.key}">${dept.value}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>

            </td>
        </tr>
        <tr>
            <td>Experience:</td><td><form:input path="experience" size="10" maxlength="10" />
            <br/>&nbsp;<font size="2+"><b>Enter in year and months e.g.; 15.6</b></font></td>
        </tr>
        <tr>
            <td>Address:</td><td><form:input path="address" size="40" maxlength="250"/></td>
        </tr>
        <tr>
            <td>Date Of Birth:</td><td>
                <form:input path="dob" type="text" id="dobDate" size="10" maxlength="10" /><a href="javascript:NewCal('dobDate','ddmmyyyy')"><img src="../../../app/images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
                <span class="descriptions">pick a date of birth..</span>
                <br/>&nbsp;<font size="2"><b>Insert date format as DD-MM-YYYY</b></font></td>
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
                    <input type="submit"  value="Submit"  />&nbsp;
                </c:otherwise>
            </c:choose>
            <input type="button"  value="Reset" onclick="resetDoctor();"/></td>
    </tr>
</table>


</form:form>

<style>
    .col-sm-6 {
        width: 20%;
    }
</style>
</body>
</html>
