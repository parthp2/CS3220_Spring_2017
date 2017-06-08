<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">

<div id="csns_header">
  <div class="wrap">
		<a href="#">
		<img style="border: 0;margin-left:100px;margin-top:2px;" id="csns_logo"  alt="csns" src="img/filemanager.png" height="75px" width="75px">
		</a>
		<div id="lpanel" style="margin-right:200px;">
		<a href="<c:url value='/Homepage' />" style="text-decoration:none;color:white;"><c:out value='${uname}' /> Profile</a>&nbsp; | &nbsp;<a href="<c:url value='/Logout' />" style="text-decoration:none;color:white;">Logout</a>
		</div>
	</div>
</div> 

<div id="content">

<ul id="title"><li>
<a href="<c:url value='/Homepage' />" style="text-decoration:none">..</a>\\
Shared Files</li></ul>


<c:if test="${fn:length(Files) > 0}">

	<table border="1" cellpadding="1" cellspacing="1" class="viewtable">
	
	<thead>
	
	<tr>
	
	<th scope="col">Name</th>
	
	<th scope="col">Date</th>
	
	<th scope="col">Size</th>
	
	
	</tr>
	
	</thead>
	
	<tbody>
	
	
	
	 <c:forEach items="${Files}" var="loop">
	 	 	
	 		<tr>
	 		
	 			<td>
	 			
	 			<a href="<c:url value='/Download?Id=${loop.id}' />" style='text-decoration:none'>
	 			<img border="0" alt="[*]" title="Toggle Public/Private" src="img/icons/closed_book.png">
	 			${loop.name}</a></td>
	
	 			
	 			<td><fmt:formatDate value="${loop.date}"  pattern="MM/dd/yy hh:mm aa" /></td>
	 			
	 				<c:if test="${loop.size <1024}">
	 				
	 				    <td>${loop.size} B</td>
	 				    
	 				</c:if>
	 				
	 				
	 				<c:if test="${loop.size >1024}">
	 				
	 				    <td><fmt:parseNumber  integerOnly="true" type="number" value="${loop.size / 1024}" /> KB</td>
	 				    
	 				</c:if>
	
	 		
	 		</tr>
	 	
	 
	 
	 </c:forEach>
	
	</tbody>
	
	</table>

</c:if>
</div>
</body>
</html>