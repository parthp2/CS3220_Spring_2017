<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result of your Test</title>
</head>
<body>
<table border="1">
<thead>
	<th>Question</th>
	<th>Correct Answer</th>
	<th>Your Answer</th>
</thead>
<tbody>
<c:forEach items="${res}" var="loop">
   <tr>
   		<td> <c:out value="${loop.question}"/></td>
   		<td> <c:out value="${loop.cans}"/></td>
   		<td> <c:out value="${loop.yans}"/></td>
   </tr>
</c:forEach>
</tbody>
</table>

<p>Your Score:<c:out value="${count} / ${size}"/></p>

<p><a href="DrivingTestBrowser" style="text-decoration:none">Start Over</a></p>
</body>
</html>