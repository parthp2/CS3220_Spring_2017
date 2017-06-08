<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty - Add Department</title>
</head>
<body>
<h3><a href="DisplayFaculty">ECST Faculty</a> &gt; Edit Department</h3>
<form action="EditDepartment" method="post">
       Department:
   <c:forEach items="${departments}" var="department">
       <input type="hidden" name="id" value="${department.id}" />
       <input type="text" name="dname" value="${department.name}" />
      <input type="submit" name="add" value="Add" />
  </c:forEach>
</form>
</body>
</html>