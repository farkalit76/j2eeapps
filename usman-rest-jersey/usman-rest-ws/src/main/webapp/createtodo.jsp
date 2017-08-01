<%-- 
    Document   : createtodo.jsp
    Created on : 29 Jun, 2017, 3:44:23 PM
    Author     : fusman
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Form to create a new resource</title>
    </head>
    <body>
        <%
            out.print("Response: ");
            if( request.getAttribute("NEWTODO") != null )
            {
               String result = (String) request.getAttribute("NEWTODO");
               out.print("Response: "+result);
            }

        %>
        <form action="../usman-rest-ws/rest/todos/create" method="POST">
            <table>
                <tr>
                    <td><label for="id">ID</label></td>
                    <td> <input name="id" /></td>
                </tr>
                 <tr>
                    <td><label for="summary">Summary</label></td>
                    <td><input name="summary" /></td>
                </tr>
                <tr>
                    <td><label for="desc">Description:</label></td>
                    <td><TEXTAREA NAME="description" COLS=40 ROWS=3></TEXTAREA></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
            
        </form>
</body>
</html> 

