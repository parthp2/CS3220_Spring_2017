<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SubFolders</title>
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

<ul id="title">
<c:forEach items="${Files1}" var="loop">
	
		<c:if test="${loop.parent ne 0}">
		<li>
		<a href="<c:url value='/SubFolder?Id=${loop.parent}' />"  style="text-decoration:none">..</a>\\
		
		</c:if>
		
		<c:if test="${loop.parent eq 0}">
		
		<a href="<c:url value='/Homepage' />" style="text-decoration:none">..</a>\\
		
		</c:if>
		
		${loop.name}
		
		
		
		</li>
		
</ul>

		<p>[<a href="<c:url value='/NewFolder?Id=${loop.id}' />" style="text-decoration:none">New Folder</a>]
		
		[<a href="<c:url value='/Upload?Id=${loop.id}' />" style="text-decoration:none">Upload File</a>]</p>
		
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
	    
	    <c:forEach items="${Files2}" var="lop">
	    
	     <c:if test="${lop.uid eq uid}">
	
	        <c:if test="${lop.parent eq loop.id}">
	        
	        <tr>
	        
	        	<c:if test="${lop.folder}">
	        	
	        	<td><a href=<c:url value='/SubFolder?Id=${lop.id}' /> style="text-decoration:none">
	        	<img border="0" alt="[*]" title="Toggle Public/Private" src="img/icons/closed_folder.png">
	        	${lop.name}</a></td>
	        	
	        	</c:if>
	        	
	        	<c:if test="${!lop.folder}">
	        	
	        	<td><a href="<c:url value='/Download?Id=${lop.id}' />" style='text-decoration:none'>
	        	<img border="0" alt="[*]" title="Toggle Public/Private" src="img/icons/closed_book.png">
	        	${lop.name}</a></td>
	        	
	        	</c:if>
	        	
	        	<td><fmt:formatDate value="${lop.date}"  pattern="MM/dd/yy hh:mm aa" /></td>
	        	
	        	<c:if test="${lop.folder}">
	 			
	 			<td></td>
	 			
	 			</c:if>
	 			
	 			<c:if test="${!lop.folder}">
	 			
	 				<c:if test="${lop.size <1024}">
	 				
	 				    <td>${lop.size} B</td>
	 				    
	 				</c:if>
	 				
	 				
	 				<c:if test="${lop.size >1024}">
	 				
	 				    <td><fmt:parseNumber  integerOnly="true" type="number" value="${lop.size / 1024}" /> KB</td>
	 				    
	 				</c:if>
	 			
	 		    </c:if>
	 		    
	 		    <td><a href="<c:url value='/EditFolder?Id=${lop.id}' />" style='text-decoration:none'>
	 		    	<img alt="[Edit]" title="Edit" src="img/icons/edit.gif" border="0">
	 		    Rename</a> | <a href="<c:url value='/DeleteFolder?Id=${lop.id}' />" style='text-decoration:none'>Delete</a></td>
	        
	        </c:if>
	        
	       </c:if>
	        
	     </c:forEach>
	

</c:forEach>
</div>
</body>
</html>