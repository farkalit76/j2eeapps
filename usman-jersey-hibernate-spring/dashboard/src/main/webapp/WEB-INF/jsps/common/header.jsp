<%-- 
    Document   : header
    Created on : 22 Oct, 2015, 10:57:49 AM
    Author     : 72010995
--%>

<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table width="100%" height="100px" border="1" bgcolor="lightgreen" cellspacing="0" >
    <tr>
        <td width="100px" align="left">
            <img src="/dashboard/app/images/medical.png" alt="Health Logo" title="Health Logo"/>
        </td>
        <td><p align="right"><a href="../../../app/views/medical/show">Home</a> &nbsp; <a href="/dashboard">Logout</a></p>
            <c:if test="${ not empty hospital}">
                <center><h2>Welcome ${hospital.name}</h2></center>
                <p align="center">${hospital.address}</p>
            </c:if>
        </td>
        <td width="100px" align="right">
            <img src="/dashboard/app/images/medical.png" alt="Health Logo" title="Health Logo"/>
        </td>
</tr>
</table>

