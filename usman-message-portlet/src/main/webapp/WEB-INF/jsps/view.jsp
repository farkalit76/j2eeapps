<%@ include file="/WEB-INF/jsps/common.jsp"%>

<portlet:defineObjects />

<%-- <portlet:actionURL var="openMessagePage">
    <portlet:param name="action" value="open-message"/>
</portlet:actionURL> --%>

<portlet:renderURL var="addMessageURL">
	<portlet:param name="render" value="open-message"></portlet:param>
</portlet:renderURL>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function newMessage() {
		//alert('create new message.');
		location.href = "${addMessageURL}";
	}
</script>
<body>
	<table
		style="border: 1px solid; padding-left: 5px; border-color: black;"
		width="100%">
		<thead>
			<tr style="border: 1px solid;" height="30">
				<th >Name</th>
				<th >Message</th>

			</tr>
		</thead>
	

		<c:choose>
			<c:when test="${not empty entries}">

				<c:forEach var="docs" items="${entries}">
						<tr>
							<td>${docs.name}</td>
							<td>${docs.message}</td>
			
						</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="11" width="800px">No Record Found into the
						database.</td>
				</tr>
			</c:otherwise>
		</c:choose>


	</table>

	Hello Spring page.......
	<button name="Add Message" value="Add Message" onclick="newMessage();">Add
		Message</button>
</body>
</html>