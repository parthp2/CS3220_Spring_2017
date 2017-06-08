<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Reservation</title>
</head>
<body>
<table border="1">
<c:set var="lop" value="${param.Res}"  scope="page"/>
<thead>
  <tr>
	<th></th>
	<c:forEach items="${Day}" var="loop">
   		<th> <c:out value="${loop.day}"/></th> 
   	</c:forEach>
   	
   	</tr>
   <c:forEach items="${Slot}" var="loop">
   <tr>
    
   	    <c:if test="${loop.slot eq 1}"><td>08:00-09:00</td>
   	       <c:forEach items="${Res}" var="Res">
   	    	<td> <c:if test="${Res.slot eq '1' and Res.day eq 'MON'}"><c:out value="${Res.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res.slot eq '1' and Res.day eq 'TUE'}"><c:out value="${Res.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res.slot eq '1' and Res.day eq 'WED'}"><c:out value="${Res.faculty}"/></c:if></td>
   	    	<td> <c:if test="${Res.slot eq '1' and Res.day eq 'THU'}"><c:out value="${Res.faculty}"/></c:if></td>
   	    	<td> <c:if test="${Res.slot eq '1' and Res.day eq 'FRI'}"><c:out value="${Res.faculty}"/></c:if></td>
   	    	</c:forEach>
       </c:if>
   		<c:if test="${loop.slot eq 2}"><td>09:00-10:00</td>
   			 <c:forEach items="${Res}" var="Res1">
   			 <td> <c:if test="${Res1.slot eq '2' and Res1.day eq 'MON'}"><c:out value="${Res1.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res1.slot eq '2' and Res1.day eq 'TUE'}"><c:out value="${Res1.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res1.slot eq '2' and Res1.day eq 'WED'}"><c:out value="${Res1.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res1.slot eq '2' and Res1.day eq 'THU'}"><c:out value="${Res1.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res1.slot eq '2' and Res1.day eq 'FRI'}"><c:out value="${Res1.faculty}"/></c:if>  </td>
   			 </c:forEach>
   		 </c:if>
   	    <c:if test="${loop.slot eq 3}"><td>10:00-11:00</td>
   	    <c:forEach items="${Res}" var="Res2">
   	     <td> <c:if test="${Res2.slot eq '3' and Res2.day eq 'MON'}"><c:out value="${Res2.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res2.slot eq '3' and Res2.day eq 'TUE'}"><c:out value="${Res2.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res2.slot eq '3' and Res2.day eq 'WED'}"><c:out value="${Res2.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res2.slot eq '3' and Res2.day eq 'THU'}"><c:out value="${Res2.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res2.slot eq '3' and Res2.day eq 'FRI'}"><c:out value="${Res2.faculty}"/></c:if>  </td>
   			 </c:forEach>
   	     </c:if>
   	     
   		<c:if test="${loop.slot eq 4}"><td>11:00-12:00</td>
   		<c:forEach items="${Res}" var="Res3">
   		<td> <c:if test="${Res3.slot eq '4' and Res3.day eq 'MON'}"><c:out value="${Res3.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res3.slot eq '4' and Res3.day eq 'TUE'}"><c:out value="${Res3.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res3.slot eq '4' and Res3.day eq 'WED'}"><c:out value="${Res3.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res3.slot eq '4' and Res3.day eq 'THU'}"><c:out value="${Res3.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res3.slot eq '4' and Res3.day eq 'FRI'}"><c:out value="${Res3.faculty}"/></c:if>  </td>
   			 </c:forEach>
   		 </c:if>
   		
   		<c:if test="${loop.slot eq 5}"><td>12:00-13:00</td>
   		<c:forEach items="${Res}" var="Res4">
   			<td> <c:if test="${Res4.slot eq '5' and Res4.day eq 'MON'}"><c:out value="${Res4.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res4.slot eq '5' and Res4.day eq 'TUE'}"><c:out value="${Res4.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res4.slot eq '5' and Res4.day eq 'WED'}"><c:out value="${Res4.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res4.slot eq '5' and Res4.day eq 'THU'}"><c:out value="${Res4.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res4.slot eq '5' and Res4.day eq 'FRI'}"><c:out value="${Res4.faculty}"/></c:if>  </td>
   			 </c:forEach>
   		 </c:if>
   		 
   		<c:if test="${loop.slot eq 6}"><td>13:00-14:00</td>
   		<c:forEach items="${Res}" var="Res5">
   		<td> <c:if test="${Res5.slot eq '6' and Res5.day eq 'MON'}"><c:out value="${Res5.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res5.slot eq '6' and Res5.day eq 'TUE'}"><c:out value="${Res5.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res5.slot eq '6' and Res5.day eq 'WED'}"><c:out value="${Res5.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res5.slot eq '6' and Res5.day eq 'THU'}"><c:out value="${Res5.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res5.slot eq '6' and Res5.day eq 'FRI'}"><c:out value="${Res5.faculty}"/></c:if>  </td>
   			 </c:forEach>
		</c:if>
		
   		<c:if test="${loop.slot eq 7}"><td>14:00-15:00</td>
   		<c:forEach items="${Res}" var="Res6">
   		<td> <c:if test="${Res6.slot eq '7' and Res6.day eq 'MON'}"><c:out value="${Res6.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res6.slot eq '7' and Res6.day eq 'TUE'}"><c:out value="${Res6.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res6.slot eq '7' and Res6.day eq 'WED'}"><c:out value="${Res6.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res6.slot eq '7' and Res6.day eq 'THU'}"><c:out value="${Res6.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res6.slot eq '7' and Res6.day eq 'FRI'}"><c:out value="${Res6.faculty}"/></c:if>  </td>
   			 </c:forEach>
         </c:if>
         
         
   		<c:if test="${loop.slot eq 8}"><td>15:00-16:00</td>
   		<c:forEach items="${Res}" var="Res7">
   		<td> <c:if test="${Res7.slot eq '8' and Res7.day eq 'MON'}"><c:out value="${Res7.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res7.slot eq '8' and Res7.day eq 'TUE'}"><c:out value="${Res7.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res7.slot eq '8' and Res7.day eq 'WED'}"><c:out value="${Res7.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res7.slot eq '8' and Res7.day eq 'THU'}"><c:out value="${Res7.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res7.slot eq '8' and Res7.day eq 'FRI'}"><c:out value="${Res7.faculty}"/></c:if>  </td>
   			 </c:forEach>
   		 </c:if>
   		 
   		<c:if test="${loop.slot eq 9}"><td>16:00-17:00</td>
   		<c:forEach items="${Res}" var="Res8">
   		<td> <c:if test="${Res8.slot eq '9' and Res8.day eq 'MON'}"><c:out value="${Res8.faculty}"/></c:if></td>
   	    	<td><c:if test="${Res8.slot eq '9' and Res8.day eq 'TUE'}"><c:out value="${Res8.faculty}"/></c:if>   </td>
   	    	<td><c:if test="${Res8.slot eq '9' and Res8.day eq 'WED'}"><c:out value="${Res8.faculty}"/></c:if>   </td>
   	    	<td> <c:if test="${Res8.slot eq '9' and Res8.day eq 'THU'}"><c:out value="${Res8.faculty}"/></c:if>  </td>
   	    	<td> <c:if test="${Res8.slot eq '9' and Res8.day eq 'FRI'}"><c:out value="${Res8.faculty}"/></c:if>  </td>
   			 </c:forEach>
   		 </c:if>
   	
   </tr>
   </c:forEach>
</thead>
<tbody>

</table>
<form action="Reservation" method="post">

<select name="day">
   <c:forEach items="${Day}" var="loop">
   		<option> <c:out value="${loop.day}"/></option> 
   </c:forEach>
</select>

<select name="slot">
   <c:forEach items="${Slot}" var="loop">
   		<c:if test="${loop.slot eq 1}"><option value="1">08:00-09:00</option> </c:if>
   		<c:if test="${loop.slot eq 2}"><option value="1">09:00-10:00</option> </c:if>
   		<c:if test="${loop.slot eq 3}"><option value="1">10:00-11:00</option> </c:if>
   		<c:if test="${loop.slot eq 4}"><option value="1">11:00-12:00</option> </c:if>
   		<c:if test="${loop.slot eq 5}"><option value="1">12:00-13:00</option> </c:if>
   		<c:if test="${loop.slot eq 6}"><option value="1">13:00-14:00</option> </c:if>
   		<c:if test="${loop.slot eq 7}"><option value="1">14:00-15:00</option> </c:if>
   		<c:if test="${loop.slot eq 8}"><option value="1">15:00-16:00</option> </c:if>
   		<c:if test="${loop.slot eq 9}"><option value="1">16:00-17:00</option> </c:if>
   </c:forEach>
</select>

<input type="text" name="faculty">

<input type="submit" value="Reserve">

</form>
</body>
</html>