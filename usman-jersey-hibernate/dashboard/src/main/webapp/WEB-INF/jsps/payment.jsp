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
        <h1>Create New Payment</h1>
        <form:form action="create" method="post"  modelAttribute="payment" >
            <form:hidden path="moduleId" value="${paysId}"/>
            <form:hidden path="patientId" value="${patsId}"/>
            <table>
                <tr>
                    <td>Fee Type</td>
                    <td>
                <form:select path="feeType">
                    <option value="">select fee type..</option>
                    <c:forEach var="fee" items="${feetypes}">
                        <c:choose>
                            <c:when test="${not empty payment.feeType && (payment.feeType eq fee.key)}">
                                <option value="${fee.key}" selected="true">${fee.value}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${fee.key}">${fee.value}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Amount</td><td><form:input path="amount" size="20" maxlength="10" value="80"/></td>
        </tr>
        <tr>
            <td>Department</td>
            <td>
                <form:select path="department">
            <option value="">select department..</option>
            <c:forEach var="dept" items="${departments}">
                <c:choose>
                    <c:when test="${not empty payment.department && (payment.department eq dept.key)}">
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
    <td>Doctor Name</td><td>
    
    <form:select path="doctorId">
            <option value="">select doctor..</option>
            <c:forEach var="docs" items="${doctors}">
                <c:choose>
                    <c:when test="${not empty payment.doctorId && (payment.doctorId eq docs.key)}">
                        <option value="${docs.key}" selected="true">${docs.value}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${docs.key}">${docs.value}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    
    
    </td>
</tr>
<tr>
    <td>Description</td><td><form:input path="description" size="50" value=""/></td>
</tr>

</table>
<table>
    <tr>
        <td>
            <c:choose>
                <c:when test="${not empty action && (action eq 'EDIT')}">
                    <input type="submit"  value="Update" onclick="updatePayment();"/>&nbsp;
                </c:when>
                <c:otherwise>
                    <input type="submit"  value="Submit" />&nbsp;
                </c:otherwise>
            </c:choose>
            <input type="button"  value="Reset" onclick="resetPayment();"/>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>
