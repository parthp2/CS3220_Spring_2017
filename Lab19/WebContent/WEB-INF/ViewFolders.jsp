<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lab19</title>
</head>
<body>
<c:forEach items="${entries}" var="loop">

	<c:if test="${loop.folder}">
	
	<a href="<c:url value='/Lab19ViewFolder?id=${loop.id}' />">\<c:out value='${loop.name}'/></a><br/><br/>
	
	</c:if>
	
	<c:if test="${!loop.folder}">
	
	${loop.name}<br/><br/>
	
	</c:if>


</c:forEach>
</body>
</html>