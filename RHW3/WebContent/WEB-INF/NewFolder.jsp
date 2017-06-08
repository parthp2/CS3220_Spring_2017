<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Folder</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">
<div id="content">
<form action="NewFolder" method="post">
<input type="hidden" name="pfolder" value="${parent}">
<label>New Folder:</label><input type='text' class="forminput" name='nfolder'>
<input type='submit' class="subbutton" value='Create'>
</form>
</body>
</html>