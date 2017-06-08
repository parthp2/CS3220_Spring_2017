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
<form action="NewFolder" method="post">
<input type="hidden" name="pfolder" value="${parent}">
<label>New Folder:</label><input type='text' name='nfolder'>
<input type='submit' value='Create'>
</form>
</body>
</html>