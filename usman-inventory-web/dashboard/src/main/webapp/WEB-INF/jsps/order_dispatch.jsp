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
        <title>Dispatch Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
        <script type="text/javascript">
            function  updateOrder()
            {
                form = document.getElementById('order');
                form.action = 'update';
                form.submit();
            }

            function cancelView()
            {
                window.location.href = "../order/show";
            }
        </script>
    </head>
    <body>
        <h1>Dispatch Order View</h1>
        <form:form action="dispatch" method="post"  modelAttribute="order" >
            <table>
                <tr>
                    <td>Order ID</td><td><form:input path="moduleId" value="${orderId}"/></td>
                </tr>
                 <tr>
                    <td>Product ID</td><td><form:input path="prodId" value="${prodId}"/></td>
                </tr>
                <tr>
                    <td>Product Name</td><td><form:input path="prodName" size="20" /></td>
                </tr>
                <tr>
                    <td>Quantity</td><td><form:input path="quantity" size="10" value="1" /></td>
                </tr>
                <tr>
                    <td>Amount</td><td><form:input path="amount" size="20" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>Customer ID</td><td><form:input path="custId" value="${custId}"/></td>
                </tr>
                <tr>
                    <td>Customer Name</td><td><form:input path="custName" value="${custName}"/></td>
                </tr>
                <tr>
                    <td>Description</td><td><form:input path="description" size="50" /></td>
                </tr>

            </table>
            <table>
                <tr>
                    <td>
                        <input type="submit"  value="Dispatch" />&nbsp;
                        <input type="button"  value="Cancel" onclick="cancelView();"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
