<%-- 
    Document   : index
    Created on : 22 Oct, 2015, 10:35:50 AM
    Author     : 72010995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory System</title>
        <script type="text/javascript" >
            function startApplication()
            {
                var user = document.forms[0].user.value;
                var password = document.forms[0].password.value;
                if (user !== '' && password !== '')
                {
                    if(user =='usman' && password == 'usman123')
                    {
                        window.location.href = "app/views/inventory/show";
                    }
                    else
                    {
                        alert('Please enter valid credentials.');
                        return false;
                    }
                }
                else
                {
                    alert('Please enter your user and password.');
                    return false;
                }
            }
        </script>
    </head>
    <body bgcolor="#eee">
        <form name="userForm" >
            <p height="200px">&nbsp;</p>
            <center>
                <h1>Welcome to Usha Inventory System</h1>
                <table width="300px" cellpadding="5" cellspacing="2">
                    <tr>
                        <td colspan="2"><b><font size="4">Please enter your credentials.</font></b></td>
                    </tr> 

                    <tr>
                        <td>User:</td><td><input name="user" value="" placeholder="enter user name" /></td>
                    </tr>  
                    <tr>
                        <td>Password:</td><td><input type="password" name="password" value="" placeholder="enter password"/></td>
                    </tr>

                </table>
                <input type="button" name="btnStart" value="Start Application" onclick="startApplication();"/>
            </center>
        </form>
    </body>
</html>
