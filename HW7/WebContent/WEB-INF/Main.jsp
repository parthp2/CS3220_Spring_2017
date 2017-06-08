<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">
<div id="content">

<ul id="title"><li style="text-align:center;">Welcome To FileManager</li></ul>

<p style="text-align:center;"> <a href="<c:url value='/Login' />" class="subbutton" style="text-decoration:none;">Login</a>    <a href="<c:url value='/Register' />" class="subbutton" style="text-decoration:none;">Register</a></p>
</body>
</html>