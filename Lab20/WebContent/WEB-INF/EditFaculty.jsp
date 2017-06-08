<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty - Add Faculty</title>
</head>
<body>
<h3><a href="DisplayFaculty">ECST Faculty</a> &gt; Add Faculty</h3>
<form action="EditFaculty" method="post">
<table border="1">
<c:forEach items="${faculty}" var="faculty">
  <tr>
    <th>Department:</th>
    <td>
      <select name="department">
       
        	<c:forEach items="${departments}" var="department">
      
      		<c:if test="${department.name eq faculty.dname}">
      		<option selected>${faculty.dname}</option>
      		</c:if>
      
      		<c:if test="${department.name ne faculty.dname}">
      		<option>${department.name}</option>
      		</c:if>
      
            </c:forEach>
        
       
      </select>
    </td>
  </tr>
  <tr>
    <th>Name:</th>
    <input type="hidden" name="id" value="${faculty.id} "/>
    <td><input type="text" name="faculty" value="${faculty.name} "/></td>
  </tr>
  <tr>
    <th>Chairperson:</th>
    
            <c:if test="${faculty.chair eq true}">
      		 <td><input type="checkbox" name="chair" checked/></td>
      		</c:if>
      		
            <c:if test="${faculty.chair ne true}">
      		 <td><input type="checkbox" name="chair" /></td>
      		</c:if>
    
  <tr>
    <td colspan="2">
      <input type="submit" name="add" value="Add" />
    </td>
  </tr>
  
   </c:forEach>
</table>
</form>
</body>
</html>