<%-- 
    Document   : file_upload
    Created on : 3 Nov, 2015, 10:35:09 AM
    Author     : 72010995
--%>
<%@include file="common/includes.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Page</title>
    </head>
    <body>
        <h2>File Upload</h2>

        <form:form method="POST" modelAttribute="fileUpload" enctype="multipart/form-data" action="upload">

            Please select a file to upload : <br/>
            Client Name: <input type="text" name="client" value="NIS" size="20"/>
            <br/>
            Select CSV File: <form:input type="file" path="csvfile" />
            <input type="submit" value="Upload" />

        </form:form>

        <br/>
        <hr/>
        <%
            String contextName = request.getContextPath().toString();
        %>
    <li>File Download <a href="<%= contextName%>/app/views/files/download">File Download Test</a></li>
    
     <li>CSV Download <a href="<%= contextName%>/app/views/files/csvDownload">CSV Download Test</a></li>
</body>
</html>
