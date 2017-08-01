
<%
    String contextName = request.getContextPath().toString();
%>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello World!</h1>
         <ol>
            <li>Employee Page: <a href="<%= contextName %>/app/views/first/employee">Employee</a></li>
            <li>Customer Page: <a href="<%= contextName %>/app/views/first/customer">Customer</a></li>
            <li>Locale Test: <a href="<%= contextName %>/app/views/locale/test">Locale</a> (Change /test?lang=en  OR /test?lang=zh_CN)</li>
            <li>Context/Config Test: <a href="<%= contextName %>/app/views/context/test">Context</a></li>
            <li>Aspect Test: <a href="<%= contextName %>/app/views/aspect/test">AOP</a></li>
            
            <li>File Upload: <a href="<%= contextName %>/app/views/files/display">Upload/Download Test</a></li>
            
            <li>Image Upload: <a href="<%= contextName %>/app/views/image/display">Image Upload/Download Test</a></li>
        </ol>
    </body>
</html>
