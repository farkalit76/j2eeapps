<%-- 
    Document   : product_search
    Author     : 72010995
--%>

<script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
<script type="text/javascript">
    function clearDeafult()
    {
        document.forms[0].moduleId.value = '';
        document.forms[0].unitPrice.value = '';
    }
</script>
<body onload="clearDeafult()" >
<h2>Search Stock</h2>
<form:form action="search" method="post"  modelAttribute="productSearch" >
    <table>
        <tr>
            <td>Product ID:</td>
        </tr> 
        <tr>
            <td><form:input path="moduleId" /></td>
        </tr> 
        <tr>
            <td>Name:</td>
        </tr>  
        <tr>
            <td><form:input path="name" /></td>
        </tr>  
        <tr>
            <td>Description:</td>
        </tr>
        <tr>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td>Unit Price:</td>
        </tr>
        <tr>
            <td><form:input path="unitPrice" /></td>
        </tr>

    </table>
    <table>
        <tr>
            <td>
                <input type="submit"  value="Search" />&nbsp;
                <input type="button" value="Reset" onclick="resetProductSearch();"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
