<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
  
   $(".subbutton").click(function(){
      var username = $("#username").val();
      var password= $("#password").val();
      if( username != "" && password != "" )
          $.ajax({
              url: "Register",
              type:'POST',
              data: {
                  "username": username,
                  "password": password
              },
              success: function(data){
            	  console.log(data);
                
            	  if(data.s==0)
            		  {
            		  window.location.href = 'Login';
            		  }
            	  else
            		 {
           		       alert("This username is already exist try another one!")
            		 }
                	 
                	
              }
          });
   });
});
</script>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">
<div id="content">

<ul id="title"><li style="text-align:center;">Register</li></ul>


<table>
<tr>
<td><label>Username:</label></td><td><input type='text' class="forminput" id="username" name='username' required></td>
</tr>
<tr>
<td><label>Password:</label></td><td><input type='password' class="forminput" id="password" name='password' required></td>
</tr>

<tr><td>
</td><td>
<input type='button' class="subbutton" value='Register'>
</td>
</tr>


</table>

</body>
</html>