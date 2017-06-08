<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<meta charset="ISO-8859-1">
<title>Edit Folder</title>
</head>
<body id="main">
<div id="content">
<form action="EditFolder" method="post">
	
	<input type='hidden' name='eid' value='${eid}'>
	
	<label>Edit Folder:</label><input type='text' class="forminput" name='efolder' value="${ename}">
	
	<input type='submit' class="subbutton" value='Save'>

</form>
</div>
</body>
</html>