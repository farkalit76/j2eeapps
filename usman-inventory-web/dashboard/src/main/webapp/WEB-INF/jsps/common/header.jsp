<%-- 
    Document   : header
    Created on : 22 Oct, 2015, 10:57:49 AM
    Author     : 72010995
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String context = request.getContextPath();
%>
<table width="100%" height="100px" border="1" bgcolor="#A0D5D2" cellspacing="0" >
    <tr>
        <td width="100px" align="left">
            <img src="<%=context%>/app/images/inventory.jpg" alt="Health Logo" title="Health Logo"/>
        </td>
        <td><p align="right"><a href="../../../app/views/inventory/show">Home</a> &nbsp; <a href="<%=context%>">Logout</a></p>
            <c:if test="${ not empty company}">
                <center><h2>Welcome ${company.name}</h2></center>
                <p align="center">${company.address}</p>
            </c:if>
        </td>
        <td width="100px" align="right">
            <img src="<%=context%>/app/images/inventory.jpg" alt="Health Logo" title="Health Logo"/>
        </td>
</tr>
</table>

