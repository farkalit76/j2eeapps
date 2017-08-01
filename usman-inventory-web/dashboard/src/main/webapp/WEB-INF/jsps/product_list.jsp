<%-- 
    Document   : product_list
    Author     : 72010995
--%>

<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory System</title>
        <script type="text/javascript">
            function openNewProduct()
            {
                window.location.href = "new";
            }
            function confirmDialog()
            {
                if(confirm('Are you sure you want to delete this product?'))
                {
                    return true;
                }
                return false;
            }
        </script>
    </head>
    <body>
        <table border="1" width="100%" cellspacing="0" height="800px">
            <tr>
                <td width="16%" valign="top">
                    <!-- display product search -->
                    <%@include file="product_search.jsp" %>
                </td>
                <td valign="top">
                    <!-- display product lists-->
                    
                    <h3>Display Product List</h3>

                    <table border="1" cellspacing="0" cellpading="2" valign="top" width="90%">
                        <tr bgcolor="#ccddff">
                            <td width="5%">ID</td>
                            <td width="15%">Name</td>
                            <td width="30%">Description</td>
                            <td width="10%">Avail. Qty</td>
                            <td width="10%">Unit Price</td>
                            <td width="15%">Image</td>
                            <td width="10%">&nbsp;</td>
                        </tr>

                        <c:choose>
                            <c:when test="${not empty products}">
                                <c:forEach var="prods" items="${products}">
                                    <tr>
                                        <td>${prods.moduleId}</td>
                                        <td>${prods.name}</td>
                                        <td>${prods.description}</td>
                                        <td>${prods.quantity}</td>
                                        <td>${prods.unitPrice}</td>
                                        <td><img src="../../../app/images/goods.jpg" alt="${prods.picture}" title="${prods.picture}" style="width:30px;height:30px;"></td>
                                        <td>&nbsp;<button><a href="../order/new?prodId=${prods.moduleId}" alt="Product" title="Product">Order</a></button></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr >
                                    <td colspan="10" width="800px">No Result found for your search.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
