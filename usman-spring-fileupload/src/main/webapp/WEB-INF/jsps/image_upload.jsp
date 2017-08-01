<%-- 
    Document   : image_upload
    Created on : 3 Nov, 2015, 10:35:09 AM
    Author     : 72010995
--%>
<%@include file="common/includes.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Image</title>
    </head>
    <body>
        <h2>Image Upload</h2>

        <form:form method="POST" modelAttribute="imageUpload" enctype="multipart/form-data" action="upload">

            Please select a file to upload : <br/>
            Client Name: <input type="text" name="client" value="NIS" size="20"/>
            <br/>
            Select an Image ( JPG, GIF or PNG File): <form:input type="file" path="imagefile" />
            <input type="submit" value="Upload" />

        </form:form>

        <br/>
        <hr/>
        <%
            String contextName = request.getContextPath().toString();
        %>
    <li>Image Download <a href="<%= contextName%>/app/views/image/download">Image Download Test</a></li>
    
<!--     <li>CSV Download <a href="<= contextName%>/app/views/files/csvDownload">CSV Download Test</a></li>-->
</body>
</html>
