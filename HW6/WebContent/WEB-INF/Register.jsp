<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">
<div id="content">

<ul id="title"><li style="text-align:center;">Register</li></ul>
<form action="Register" method="post">

<table>
<tr>
<td><label>Username:</label></td><td><input type='text' class="forminput" name='username' required></td>
</tr>
<tr>
<td><label>Password:</label></td><td><input type='password' class="forminput" name='password' required></td>
</tr>

<tr><td>
</td><td>
<input type='submit' class="subbutton" value='Register'>
</td>
</tr>


</table>
</form>
</body>
</html>