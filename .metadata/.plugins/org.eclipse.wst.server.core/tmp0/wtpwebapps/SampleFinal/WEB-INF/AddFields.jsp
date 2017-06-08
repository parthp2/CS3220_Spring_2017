<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${Contact}" var="loop">
<p><strong><a href="<c:url value='/ContactList' />" style="text-decoration:none">Contacts</a>&nbsp;-  ${loop.name}</strong></p>

<table border="1" cellpadding="2" cellspacing="2">
	<thead>
	</thead>
	<tbody>
		<tr>
			<td><strong>Name</strong></td>
			<td>${loop.name}</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><strong>Phone</strong></td>
			<td>${loop.contact}</td>
			<td>&nbsp;</td>
		</tr>
		
		<c:forEach items="${Fields}" var="lop">
		<tr>
			<td><strong>${lop.fname} </strong></td>
			<td>${lop.fvalue}</td>
			<td>&nbsp;</td>
		</tr>
		</c:forEach>
		<form action="AddFields" method="post">
		<tr>
			<input type="hidden" name="id" value="${loop.id}">
			<td><input name="fname" type="text" /></td>
			<td><input name="fvalue" type="text" /></td>
			<td><input name="add" type="submit" value="Add" /></td>
		</tr>
		</form>
	</tbody>
</table>
</c:forEach>
</body>
</html>