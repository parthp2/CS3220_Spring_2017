<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Mapping</title>
</head>
<body>

<div style="margin-left: 40px;">

<form action="CreateMapping" method="post">
<table border="1" cellpadding="1" cellspacing="1">
	<thead>
		<tr>
			<th scope="col">Quarter Course</th>
			<th scope="col">Semester Course</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<ul>
				<c:forEach items="${Courses}" var="loop">
			
				<c:if test="${loop.term eq 'Quarter'}">
			
				<li>${loop.cname } <input name="quarter" type="radio"  value="${loop.cname }"/></li>
				
				</c:if>
				
			</c:forEach>
			
			</ul>
			</td>
			<td>
			<ul>
				<c:forEach items="${Courses}" var="loop">
			
				<c:if test="${loop.term eq 'Semester'}">
			
				<li>${loop.cname } <input name="semester" type="radio"  value="${loop.cname }"/></li>
				
				</c:if>
				
			   </c:forEach>
			</ul>
			</td>
		</tr>
	</tbody>
</table>

<p><input type="submit" name="add" value="Create Mapping"></p>

</form>
</div>


</body>
</html>