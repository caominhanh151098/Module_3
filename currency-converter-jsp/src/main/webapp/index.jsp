<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h1>Currency Converter</h1>
<form action="converter.jsp" method="post">
    <label>Rate:</label><br/>
    <input type="number" name="rate"><br/>
    <label>USD:</label> <br/>
    <input type="number" name="usd"><br/>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>