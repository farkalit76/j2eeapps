
<%
    String contextName = request.getContextPath().toString();
%>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Starting......</h1>
         <ol>
            <li>Start Page: <a href="<%= contextName %>/app/views/first/start">Start</a></li>
           
        </ol>
    </body>
</html>
