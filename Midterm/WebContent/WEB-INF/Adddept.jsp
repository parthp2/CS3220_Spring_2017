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
<h3><a href="faculty"  style="text-decoration:none;">ECST Faculty</a> > Add Department</h3>
<form action="Adddept" method="post">
<p>Department:
<input type="text" name="dname">
<input type="submit" name="add" value="Add">
</p>
</form>
</body>
</html>