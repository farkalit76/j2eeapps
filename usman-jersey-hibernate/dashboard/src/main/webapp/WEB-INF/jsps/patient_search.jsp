<%-- 
    Document   : patient_search
    Created on : 23 Oct, 2015, 9:50:47 AM
    Author     : 72010995
--%>

<script type="text/javascript" src="../../../app/jscript/medical.js" ></script>

<h2>Search Patient</h2>
<form:form action="search" method="post"  modelAttribute="patientSearch" >
    <table>
        <tr>
            <td>ID:</td>
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
            <td>Address:</td>
        </tr>
        <tr>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td>Phone:</td>
        </tr>
        <tr>
            <td><form:input path="phone" /></td>
        </tr>

    </table>
    <table>
        <tr>
            <td>
                <input type="submit"  value="Search" />&nbsp;
                <input type="button" value="Reset" onclick="resetPatientSearch();"/>
            </td>
        </tr>
    </table>
</form:form>
