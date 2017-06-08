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

<div id="content">

<ul id="title"><li>Parth's Profile</li></ul>

<p>[<a href="<c:url value='/NewFolder' />" style="text-decoration:none">New Folder</a> 
| <a href="<c:url value='/Upload' />" style="text-decoration:none">Upload File</a>]</p>

<c:if test="${fn:length(Files) > 0}">

	<table border="1" cellpadding="1" cellspacing="1" class="viewtable">
	
	<thead>
	
	<tr>
	
	<th scope="col">Name</th>
	
	<th scope="col">Date</th>
	
	<th scope="col">Size</th>
	
	<th scope="col">Operation</th>
	
	</tr>
	
	</thead>
	
	<tbody>
	
	 <c:forEach items="${Files}" var="loop">
	 	
	 	<c:if test="${loop.parent eq 0}">
	 	
	 		<tr>
	 		
	 			<c:if test="${loop.folder}">
	 			
	 			<td>
	 			
	 			<a href="<c:url value='/SubFolder?Id=${loop.id}' />" style='text-decoration:none'>
	 			<img border="0" alt="[*]" title="Toggle Public/Private" src="img/icons/closed_folder.png">
	 			${loop.name}</a></td>
	 			
	 			</c:if>
	 			
	 			<c:if test="${!loop.folder}">
	 			
	 			<td>
	 			
	 			<a href="<c:url value='/Download?Id=${loop.id}' />" style='text-decoration:none'>
	 			<img border="0" alt="[*]" title="Toggle Public/Private" src="img/icons/closed_book.png">
	 			${loop.name}</a></td>
	 			
	 			</c:if>
	 			
	 			<td><fmt:formatDate value="${loop.date}"  pattern="MM/dd/yy hh:mm aa" /></td>
	 			
	 			<c:if test="${loop.folder}">
	 			
	 			<td></td>
	 			
	 			</c:if>
	 			
	 			<c:if test="${!loop.folder}">
	 			
	 				<c:if test="${loop.size <1024}">
	 				
	 				    <td>${loop.size} B</td>
	 				    
	 				</c:if>
	 				
	 				
	 				<c:if test="${loop.size >1024}">
	 				
	 				    <td><fmt:parseNumber  integerOnly="true" type="number" value="${loop.size / 1024}" /> KB</td>
	 				    
	 				</c:if>
	 			
	 			</c:if>
	 			
	 			<td>
	 			
	 			<a href="<c:url value='/EditFolder?Id=${loop.id}' />" style='text-decoration:none'>
	 			<img alt="[Edit]" title="Edit" src="img/icons/edit.gif" border="0">
	 			Rename</a> | <a href="<c:url value='/DeleteFolder?Id=${loop.id}' />" style='text-decoration:none'>Delete</a></td>
	 		
	 		</tr>
	 	
	 	</c:if>
	 	
	 
	 </c:forEach>
	
	</tbody>
	
	</table>

</c:if>
</div>
</body>
</html>