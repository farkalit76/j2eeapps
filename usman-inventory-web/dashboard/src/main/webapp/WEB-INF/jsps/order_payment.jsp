<%-- 
    Document   : order_booked
    Created on : 21 Jul, 2017, 8:42:51 PM
    Author     : fusman
--%>
<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Payment Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
        <script type="text/javascript">

            function okButton()
            {
                window.location.href = "../product/show";
            }
        </script>
    </head>
    <body>
        <h1>Order Payment</h1>
        <table>
            <tr>
                <td>
                    <img src="../../../app/images/payment_screen.jpg" alt="Payment" title="Payment" style="width:400px;height:350px;">
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td> <input type="button"  value="Cancel" onclick="okButton();"/> </td>
                <td> <input type="button"  value="Submit" onclick="okButton();"/> </td>
            </tr>
        </table>
    </body>
</html>

