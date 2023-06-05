<%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 02/06/2023
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
    <form action="/user?action=add" method="post">
        <table>
            <caption><h3>Tạo mới User</h3></caption>
            <tr>
                <td><label for="name">Tên: </label></td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td><label for="dob">Ngày sinh: </label></td>
                <td><input type="date" name="dob" id="dob"></td>
            </tr>
            <tr>
                <td><label for="address">Địa chỉ: </label></td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Thêm"></td>
            </tr>
        </table>
    </form>
</body>
</html>
