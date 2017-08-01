<%-- 
    Document   : product
    Author     : 72010995
--%>

<%@include file="common/includes.jsp" %>
<%@include file="common/header.jsp" %>
<%@include file="common/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Info</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
    </head>
    <body>

    <h1>Create New Product</h1>
        <form:form action="create" method="post"  modelAttribute="product" >
            <form:hidden path="moduleId" />
            <table>
                <tr>
                    <td>Name:</td><td><form:input path="name" /></td>
                </tr> 
                <tr>
                    <td>Description:</td><td><form:input path="description" size="40" maxlength="250"/></td>
                </tr>
                <tr>
                    <td>Quantity:</td><td><form:input path="quantity" size="4" maxlength="4" /></td>
                </tr>
                <tr>
                    <td>Unit Price:</td><td><form:input path="unitPrice" /></td>
                </tr>
                <tr>
                    <td>Title:</td><td><form:input path="picture" /></td>
                </tr>
               
            </table>
            <table>
                <tr>
                    <td>
                         <c:choose>
                            <c:when test="${(not empty action) && (action eq 'EDITS')}">
                                <input type="submit"  value="Update" onclick="updateProduct();"/>&nbsp;
                            </c:when>
                            <c:otherwise>
                                <input type="submit"  value="Submit" />&nbsp;
                            </c:otherwise>
                        </c:choose>
                        <input type="button" value="Reset" onclick="resetProduct();"/>
                        <input type="button" value="Cancel" onclick="cancelProduct();"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
