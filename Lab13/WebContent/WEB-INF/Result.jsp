<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter Result</title>
</head>
<body>
<p><fmt:formatNumber maxIntegerDigits="3" value="${amount}" type="number" /> ${c1} <c:out value="=" /> <fmt:formatNumber maxIntegerDigits="3" value="${result}" type="number" /> ${c2}</p>
<p><a href='CurrencyConverter'>Back</a></p>
</body>
</html>