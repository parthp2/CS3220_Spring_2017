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
<h3><a href="faculty" style="text-decoration:none;">ECST Faculty</a> > Add Faculty</h3>
<table border="1" cellpadding="2">

<form action="Addfaculty" method="post">

	<tr>
		<th>Department:</th>
		<td>
		<select name="dname">
		<c:forEach items="${dept}" var="loop">	
			<option value="${loop.dname}"><c:out value="${loop.dname}"/></option>
		</c:forEach>
		</select>
		</td>
	</tr>
	
	<tr>
		<th>Name:</th>
		<td><input type="text" name="fname"></td>
	</tr>

	<tr>
		<th>ChairPerson:</th>
		<td><input type="checkbox" name="chair" value="chair"></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="Add"> </td>
	</tr>

</form>

</table>
</body>
</html>