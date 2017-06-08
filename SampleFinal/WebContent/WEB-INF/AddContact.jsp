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
<p><strong><a href="<c:url value='/ContactList' />" style="text-decoration:none">Contacts</a>&nbsp;- Add</strong></p>

<form action="AddContact" method="post">
<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th scope="row">Name:</th>
			<td><input name="name" type="text" /></td>
		</tr>
		<tr>
			<th scope="row">Phone:</th>
			<td><input name="contact" type="text" /></td>
		</tr>
		<tr>
			<th colspan="2" scope="row"><input name="apply" type="submit" value="Add" /></th>
		</tr>
	</tbody>
</table>

</form> 


</body>
</html>