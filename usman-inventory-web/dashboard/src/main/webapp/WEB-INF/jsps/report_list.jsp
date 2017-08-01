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
        <title>Report Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <table border="1" width="100%" cellspacing="0" height="800px">
            <tr>
                <td width="16%" valign="top">
                    <!-- display report search -->
                    <%@include file="report_search.jsp" %>
                </td>
                <td valign="top">
                    <!-- display report lists-->
                   
                    <h3>Display Product</h3>

                    <table border="1" cellspacing="0" cellpadding="2" width="90%">
                        <tr bgcolor="#ccddff">
                            <td width="20%">Product Name</td>
                            <td width="20%">Customer Name</td>
                            <td width="10%">Quantity</td>
                            <td width="10%">AMount</td>
                            <td width="15%">From Date</td>
                            <td width="15%">To Date</td>
                        </tr>

                        <tr>
                            <td>Xyx</td>
                            <td> Name</td>
                            <td>11</td>
                            <td>3333.90</td>
                            <td>20-Jul-2017</td>
                            <td>23-Jul-2017</td>
                        </tr>
                    </table>

        </table>
    </td>
</tr>
</table>


</body>
</html>
