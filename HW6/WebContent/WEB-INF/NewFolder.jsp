<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script>
$(function(){
  
   $("#creat").click(function(){
      var nfolder = $("#nfolder").val();
      var pfolder = $("#pfolder").val();
      if( name != "" )
          $.ajax({
              url: "NewFolder",
              data: {
                  "nfolder": nfolder,
                  "pfolder": pfolder
              },
              success: function(data){
                  var row = $("<tr data-entry-id='" + data + "'></tr>" );
                  row.append("<td>" + name + "</td>")
                     .append("<td>" + message + "</td>")
                     .append("<td><button>Delete</button></td>");
                  $("#form").before(row);
              }
          });
   });
});
</script>
<meta charset="ISO-8859-1">
<title>New Folder</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body id="main">
<div id="content">
<form action="NewFolder" method="post">
<input type="hidden" name="pfolder" id="pfolder" value="${parent}">
<label>New Folder:</label><input type='text' id="nfolder" class="forminput" name='nfolder'>
<input type='submit' class="subbutton" id="create" value='Create'>
</form>
</body>
</html>