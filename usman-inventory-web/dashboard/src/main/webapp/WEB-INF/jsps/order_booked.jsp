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
        <title>Order Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
        <script type="text/javascript">

            function paymentButton()
            {
                window.location.href = "payment";
            }
            function okButton()
            {
                window.location.href = "../product/show";
            }
        </script>
    </head>
    <body>
        <h1>Booking Order</h1>
        <table>
            <tr>
                <td>
                    Your Order has been booked. Please note down your order id <b><font color="red">${order.orderId}</font></b>
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td> To complete your booking please proceed for the payment</td>
                 <td> <input type="button"  value="Payment" onclick="paymentButton();"/></td>
            </tr>
            <tr>
                <td> You may discard your booking by pressing Discard button.</td>
                <td> <input type="button"  value="Discard" onclick="okButton();"/> </td>
            </tr>
        </table>
    </body>
</html>

