<%@ include file="/WEB-INF/jsps/common.jsp" %>

<portlet:defineObjects/>
	
<portlet:actionURL var="createMessage">
    <portlet:param name="action" value="create-message"/>
</portlet:actionURL>

<%-- <portlet:actionURL var="cancelMessage">
    <portlet:param name="action" value="cancel-message"/>
</portlet:actionURL> --%>

<portlet:renderURL var="cancelMessageURL">
		<portlet:param name="render" value="cancel-message"></portlet:param>
</portlet:renderURL>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function cancelMessage()
	{
		//alert('create new message.');
		location.href="${cancelMessageURL}";
	}
</script>

</head>
<body>
Edit page
<form:form method="post" action="${createMessage}" name="createMessageFm" id="createMessageFm" >
	Name:<input name="name" />
	Message:<input name="message"/>
	<button type="submit" name="Submit">Submit</button>
	<button type="button" name="Cancel" onclick="cancelMessage();" >Cancel</button>
        
</form:form>
</body>
</html>