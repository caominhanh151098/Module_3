<%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 02/06/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
  <%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));

    float vnd = rate * usd;
  %>
  <h1>Rate: <%=rate%></h1>
  <h1>USD: <%=usd%></h1>
  <h1>VND: <%=vnd%></h1>
</head>
<body>

</body>
</html>