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
<p><strong>Contacts</strong></p>

<p><a href="<c:url value='/AddContact' />" style="text-decoration:none">Add A Contact</a></p>


<table border="1" cellpadding="2" cellspacing="2">
	<thead>
	</thead>
	<tbody>
	
	<c:forEach items="${Contact2}" var="loop">
		<tr>
			<td colspan="2"><strong>${fn:toUpperCase(loop.letter)}</strong></td>
		</tr>
		
		<c:forEach items="${Contact}" var="lop">
		<c:if test="${loop.letter eq lop.letter}">
		<tr>
			<td><a href="<c:url value='/AddFields?id=${lop.id}' />" style="text-decoration:none">${lop.name}</a></td>
			<td>${lop.contact}</td>
		</tr>
		</c:if>
		</c:forEach>
		
		
	</c:forEach>
	</tbody>
</table>

</body>
</html>