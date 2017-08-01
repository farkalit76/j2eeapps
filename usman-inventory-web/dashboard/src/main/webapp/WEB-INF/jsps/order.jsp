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

        <script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
        <script type="text/javascript">
            function  updateOrder()
            {
                form = document.getElementById('order');
                form.action = 'update';
                form.submit();
            }
            function resetOrder()
            {
                document.forms[0].quantity.value = '';
            }

            function cancelOrder()
            {
                window.location.href = "../product/show";
            }
            function setAmount()
            {
                validate();
                var qty = document.forms[0].quantity.value;
                var unit = document.forms[0].unitPrice.value;
                var amount = parseInt(qty) * parseInt(unit);
                //alert('amount'+amount);
                document.forms[0].amount.value = amount;
                return true;
            }
            
            function validate()
            {
                var availQty = ${availQty};
                //alert('availQty'+availQty);
                var qty = document.forms[0].quantity.value;
                if( parseInt(qty) > parseInt(availQty))
                {
                    alert('Sorry! Your order quantity is greater than the available quantity. Please decrease it. ');
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <h1>Order Your Goods</h1>
        <form:form action="create" method="post"  modelAttribute="order" >
            <form:hidden path="moduleId" value="${orderId}"/>
            <form:hidden path="custId" value="${custId}"/>
            <form:hidden path="custName" value="${custName}"/>
            <table>
                <tr>
                    <td>Product ID</td><td><form:input path="prodId" value="${prodId}"/> </td>
                </tr>
                <tr>
                    <td>Product Name</td><td><form:input path="prodName" size="20" /> </td>
                </tr>
                 <tr>
                    <td>Unit Price</td><td><form:input path="unitPrice" size="20"/></td>
                </tr>
                <tr>
                    <td>Quantity</td><td><form:input path="quantity" size="10" value="1" onchange="return setAmount();" /></td>
                </tr>
                <tr>
                    <td>Amount</td><td><form:input path="amount" size="20" value="${amount}" /></td>
                </tr>

                <tr>
                    <td>Description</td><td><form:input path="description" size="50" /></td>
                </tr>

            </table>
            <table>
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${not empty action && (action eq 'EDIT')}">
                                <input type="submit"  value="Update" onclick="updateOrder();"/>&nbsp;
                            </c:when>
                            <c:otherwise>
                                <input type="submit"  value="Submit" onclick="return validate();"/>&nbsp;
                            </c:otherwise>
                        </c:choose>
                        <input type="button"  value="Reset" onclick="resetOrder();"/>
                        <input type="button"  value="Cancel" onclick="cancelOrder();"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
