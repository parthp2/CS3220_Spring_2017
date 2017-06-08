<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<title>Upload File</title>
</head>
<body id="main">
<div id="content">
<form action="Upload?Id=${id}" method='post' enctype='multipart/form-data'>
<label>File: </label><input type='file' class="forminput"name='file' />
<input type='submit'  class="subbutton" value='Upload' />
</form>
</body>
</html>