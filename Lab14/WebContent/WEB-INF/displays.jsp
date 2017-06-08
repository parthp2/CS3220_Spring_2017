<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
<form action="DrivingTestBrowser" method="post">
<input type="hidden" name="qid" value="${qes.id}">
<p>${qes.description}</p>
<p>1.${qes.answerA}<input type="radio" name="answer" value="1"> </p>
<p>2.${qes.answerB}<input type="radio" name="answer" value="2"></p>
<p>3.${qes.answerC}<input type="radio"name="answer" value="3"></p>
<p>
<input type="submit" value="Next"> 
</p>
</form>
</body>
</html>