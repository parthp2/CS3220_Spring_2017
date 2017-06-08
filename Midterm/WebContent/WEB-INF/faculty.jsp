<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ECST Faculty</title>
</head>
<body>
<h1>ECST Faculty</h1>
<p><a href="Adddept" style="text-decoration:none;">Add Department</a> | <a href="Addfaculty" style="text-decoration:none;">Add Faculty</a></p>

	<table border="1" cellpadding="2">
	
	<tr>
		<th>Department</th>
		<th>Name</th>
	</tr>
<c:forEach items="${dept}" var="loop">	
	<tr>
		<td><c:out value="${loop.dname}"/></td>
		<c:forEach items="${faculty}" var="ful">
			 <c:if test="${ful.dname eq loop.dname}">
		        <td><c:out value="${ful.fname}"/>
		        <c:if test="${ful.chair}">
		        <c:out value="(chair)"/>
		        </c:if>
		        </td>
		      </c:if>
		</c:forEach>
	</tr>
</c:forEach>
	
	
	</table>
	
	<br/>


</body>
</html>