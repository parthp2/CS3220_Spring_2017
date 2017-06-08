<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Folder</title>
</head>
<body>
<form action="EditFolder" method="post">
	
	<input type='hidden' name='eid' value='${eid}'>
	
	<label>Edit Folder:</label><input type='text' name='efolder' value="${ename}">
	
	<input type='submit' value='Save'>

</form>
</body>
</html>