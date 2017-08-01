<%-- 
    Document   : report_search
    Created on : 23 Oct, 2015, 11:15:47 AM
    Author     : 72010995
--%>

<h2>Product Report</h2>
<form:form action="search" method="post"  modelAttribute="reportSearch" >
    <table>
        <tr>
            <td>Product Name:</td>
        </tr>  
         <tr>
            <td><form:input path="doctorName" /></td>
        </tr>  
        <tr>
            <td>From Date:</td>
        </tr>
        <tr>
            <td><form:input path="strDateFrom" /></td>
        </tr>
        <tr>
            <td>To Date:</td>
        </tr>
        <tr>
           <td><form:input path="strDateTo" /></td>
        </tr>

    </table>
    <table>
        <tr>
            <td>
                <input type="submit"  value="Search" />&nbsp;
                <input type="button" value="Reset" onclick="resetSearch();"/>
            </td>
        </tr>
    </table>
</form:form>

