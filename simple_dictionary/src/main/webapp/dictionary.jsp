<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 02/06/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%
    Map<String, String> mapKey = new HashMap<>();
    mapKey.put("hello", "Chào! Chào cái *beep!");
    mapKey.put("sorry", "Xin lỗi tau đỡ không nổi!");
    mapKey.put("thank", "Cám ơn nhá thằng ngu!");
    mapKey.put("bye", "Chào thân ái và quyết thắng!!!!!!");

    String input = request.getParameter("text");
    String result = mapKey.get(input.toLowerCase());
    if (result != null) {
        out.println("Word: " + input);
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }
%>

</body>
</html>
