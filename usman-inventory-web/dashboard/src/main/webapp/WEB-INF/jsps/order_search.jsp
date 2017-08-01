<%-- 
    Document   : product_search
    Author     : 72010995
--%>

<script type="text/javascript" src="../../../app/jscript/inventory.js" ></script>
 <script type="text/javascript">
    function resetProductSearch()
    {
        document.forms[0].moduleId.value = '';
        document.forms[0].prodId.value = '';
        document.forms[0].prodName.value = '';
        document.forms[0].description.value = '';
        document.forms[0].dispatched.value = '';
    }

    function clearDeafult()
    {
        document.forms[0].moduleId.value = '';
        document.forms[0].prodId.value = '';
    }
</script>
<body onload="clearDeafult()" >
<h2>Search Order</h2>
<form:form action="search" method="post"  modelAttribute="orderSearch" >
    <table>
        <tr>
            <td>Order ID:</td>
        </tr> 
        <tr>
            <td><form:input path="moduleId" /></td>
        </tr> 
        <tr>
            <td>Product ID:</td>
        </tr> 
        <tr>
            <td><form:input path="prodId" /></td>
        </tr> 
        <tr>
            <td>Product Name:</td>
        </tr>  
        <tr>
            <td><form:input path="prodName" /></td>
        </tr>  
        <tr>
            <td>Description:</td>
        </tr>
        <tr>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td>Dispatched:</td>
        </tr>
        <tr>
            <td><form:input path="dispatched" /></td>
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
