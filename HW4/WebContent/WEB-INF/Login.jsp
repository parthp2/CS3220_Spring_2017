<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">
<div id="content">

<ul id="title"><li style="text-align:center;">Login</li></ul>
<form action="Login" method="post">

<table>
<tr>
<td><label>Username:</label></td><td><input type='text' class="forminput" name='username'></td>
</tr>
<tr>
<td><label>Password:</label></td><td><input type='password' class="forminput" name='password'></td>
</tr>

<tr><td>
</td><td>
<input type='submit' class="subbutton" value='Login'>
</td>
</tr>



</table>
</form>

<p></p>
<a href="Register" style="text-decoration:none;">Register over here !</a>

</body>
</html>