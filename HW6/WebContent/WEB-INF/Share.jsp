<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sharing Page</title>
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
Share File with Other Users | <a href="<c:url value='/Homepage' />" style="text-decoration:none">Homepage</a></li></ul>

<c:if test="${fn:length(users) > 0}">

	<table border="1" cellpadding="1" cellspacing="1" class="viewtable">
	
	<thead>
	
	<tr>
	
	<th scope="col">Name</th>

	
	<th scope="col">Operation</th>
	
	</tr>
	
	</thead>
	
	<tbody>
	
	<tr><td>Share with everyone</td><td><a href="<c:url value='/ShareFolder?FId=${FID}&UId=0' />" style='text-decoration:none'>Share</a></td></tr>
	
	 <c:forEach items="${users}" var="loop">
	 
	 
	 		<tr>
	 		
	 			
	 			<td>${loop.uname}</td>
	 			
	 			<td>
	 		   
	 		    
	 		     <a href="<c:url value='/ShareFolder?FId=${FID}&UId=${loop.uid}' />" style='text-decoration:none'>Share</a>
	 			
	 			
	 			</td>
	 		
	 		</tr>
	 	
	 	
	 
	 </c:forEach>
	
	</tbody>
	
	</table>

</c:if>
</div>
</body>
</html>