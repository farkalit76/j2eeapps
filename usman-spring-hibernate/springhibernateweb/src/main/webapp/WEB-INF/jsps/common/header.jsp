<%-- 
    Document   : header
    Created on : 22 Oct, 2015, 10:57:49 AM
    Author     : 72010995
--%>
<%
    String contextName = request.getContextPath().toString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table width="100%" height="100px" border="1" bgcolor="lightgreen" cellspacing="0" >
    <tr>
        <td width="100px" align="left">
            <img src="/springhibernateweb/app/images/medical.png" alt="Health Logo" title="Health Logo"/>
        </td>
        <td><p align="right"><a href="../../../app/views/user/show">Home</a> &nbsp; <a href="<%= contextName %>">Logout</a></p>
            <center><h1>Medical Online! </h1></center>
        </td>
        <td width="100px" align="right">
            <img src="<%= contextName %>/app/images/medical.png" alt="Health Logo" title="Health Logo"/>
        </td>
</tr>
</table>

