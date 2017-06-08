<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Courses</title>
</head>
<body>
<form action="AddCourse" method="post">
<p style="clear: both; margin-left: 40px;">Course: <input name="cname" type="text" /> 
<select name="term">
 <option>Quarter</option>
 <option>Semester</option>
 </select>&nbsp;
 
 <input type="submit" name="add" value="Add">
 
 </form>
 
 </p>

</body>
</html>