<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>


<p style="margin-left: 40px;"><a href="<c:url value='/AddCourse' />" style="text-decoration:none">Add Course</a> | <a href="<c:url value='/CreateMapping' />" style="text-decoration:none">Create Course Mapping</a></p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="1" cellspacing="1">
	<thead>
		<tr>
			<th scope="col">Quarter Courses</th>
			<th scope="col">Semester Courses</th>
			<th scope="col">Course Mappings</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<ul>
			
			<c:if test="${fn:length(Courses) > 0}">
			
			<c:forEach items="${Courses}" var="loop">
			
				<c:if test="${loop.term eq 'Quarter'}">
			
				<li>${loop.cname }</li>
				
				</c:if>
				
			
			</c:forEach>
			
			</c:if>
			
			</ul>
			</td>
			<td>
			<ul>
			
			<c:if test="${fn:length(Courses) > 0}">
			
				<c:forEach items="${Courses}" var="loop">
			
				<c:if test="${loop.term eq 'Semester'}">
			
				<li>${loop.cname }</li>
				
				</c:if>
				
			   </c:forEach>
			   
			 </c:if>
			</ul>
			</td>
			<td>
			<ul>
				<c:if test="${fn:length(Courses2) > 0}">
			
				<c:forEach items="${Courses2}" var="lop">
			
				<li>(${lop.qcname}, ${ lop.scname})</li>
				
			   </c:forEach>
			   
			 </c:if>
				
			</ul>
			</td>
		</tr>
	</tbody>
</table>
</div>

</body>
</html>