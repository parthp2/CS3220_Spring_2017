<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
	function deleteEntry(){
		
		 var row = $(this).closest("tr");
	       $.ajax({
	           url: "AjaxDeleteEntry",
	           data: {
	               "id" : row.attr("data-entry-id")
	           },
	           success: function(){
	               row.remove();
	           }
	       });
		
	}
	
   $(".delete").click(deleteEntry);
   
   $("#add").click(function(){
      var name = $("#name").val();
      var newdel=$("<td><button>Delete</button></td>");
      var message = $("#message").val();
      if( name != "" && message != "" )
          $.ajax({
              url: "AjaxAddEntry",
              data: {
                  "name": name,
                  "message": message
              },
              success: function(data){
                  var row = $("<tr data-entry-id='" + data + "'></tr>" );
                  row.append("<td class='edit-name'>" + name + "</td>")
                     .append("<td class='edit-msg'>" + message + "</td>")
                     .append(newdel);
                  newdel.click(deleteEntry);
                  $("#form").before(row);
              }
          });
      
   });
   
   $(".edit-name").dblclick(function(){
	   var row = $(this).closest("tr");
	   var td = $(this);
       var content = td.text();
       var input = $("<input type='text' />").val(content);
       input.blur(function(){
          if( input != ""  )
              $.ajax({
                  url: "AjaxEditEntry",
                  data: {
                	  "id":row.attr("data-entry-id"),
                      "name":$(this).val() 
                     
                  },
                  success: function(data){
                	  var value = $(this).val();
                      td.empty().text( value );
                  }
       });
          
       });
       $(this).empty().append(input);
     
   });
   
   
   $(".edit-msg").dblclick(function(){
	   var row = $(this).closest("tr");
	   var td = $(this);
       var content = td.text();
       var input = $("<input type='text' />").val(content);
       input.blur(function(){
          if( input != ""  )
              $.ajax({
                  url: "AjaxEditEntry2",
                  data: {
                	  "id":row.attr("data-entry-id"),
                      "message": $(this).val()
                  },
                  success: function(data){
                	  var value = $(this).val();
                      td.empty().text( value );
                  }
       });
          
       });
       $(this).empty().append(input);
     
   });
 

});
</script>
</head>
<body>
<h2>GuestBook</h2>
<table border="1">
  <tr><th>Name</th><th>Message</th><th></th></tr>
  <c:forEach items="${entries}" var="entry">
  <tr data-entry-id="${entry.id}">
    <td class="edit-name">${entry.name}</td>
    <td class="edit-msg">${entry.message}</td>
    <td><button class="delete">Delete</button></td>
  </tr>
  </c:forEach>
  <tr id="form">
    <td><input id="name" type="text" /></td>
    <td><input id="message" type="text" /></td>
    <td><button id="add">Add</button></td>
</table>
</body>
</html>