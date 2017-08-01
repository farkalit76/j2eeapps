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
        <title>Stock Page</title>
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
                    <%@include file="stock_search.jsp" %>
                </td>
                <td valign="top">
                    <!-- display product lists-->
                    <div align="center" valign="top"></div>
                    <h3>Display Stock List <input type="button" value="Add New Product" onclick="openNewProduct();"/></h3>

                    <table border="1" cellspacing="0" cellpading="2" valign="top" width="95%">
                        <tr bgcolor="#ccddff">
                           
                            <td width="5%">ID</td>
                            <td width="10%">Name</td>
                            <td width="20%">Description</td>
                            <td width="10%">Avail. Qty</td>
                            <td width="10%">Unit Price</td>
                            <td width="15%">Image</td>
                            <td width="20%">Created Date</td>
                            <td width="10%"/>Actions</td>
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
                                        <td><fmt:formatDate pattern="dd-MMM-yyyy HH:mm:ss a" value="${prods.createdDate.time}" /></td>
                                        <td>
                                            &nbsp;<a href="edit?prodId=${prods.moduleId}" ><img src="../../../app/images/edit.png" alt="Edit" title="Edit"/></a>&nbsp;&nbsp;
                                            &nbsp;<a href="delete?prodId=${prods.moduleId}" onclick="javascript:return confirmDialog();" ><img src="../../../app/images/delete.gif" alt="Delete" title="Delete"/></a>&nbsp;
                                        </td>
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
