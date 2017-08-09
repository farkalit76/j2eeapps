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
        <title>Medical Life</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <table border="1" width="100%" cellspacing="0" height="800px">
            <tr>
                <td width="22%" valign="top">
                    <!-- display report search -->
                    <%@include file="report_search.jsp" %>
                </td>
                <td valign="top">
                    <!-- display report lists-->
                   
                    <h3>Display Report</h3>

                    <table border="1">
                        <tr>
                            <td>Patient Name</td>
                            <td>Disease</td>
                            <td>Doctor's Name</td>
                            <td>Date Visiting</td>
                            <td>Amount Paid</td>
                            <td>Medicine Purchased</td>
                            <td>Lab Test</td>
                            <td>Operation</td>
                        </tr>

                        <tr>
                            <td>Akbar</td>
                            <td>Fever</td>
                            <td>Dr. Amjad</td>
                            <td>30/09/2015</td>
                            <td>200</td>
                            <td>Yes</td>
                            <td>No</td>
                            <td>No</td>
                        </tr>
                    </table>

        </table>
    </td>
</tr>
</table>


</body>
</html>
