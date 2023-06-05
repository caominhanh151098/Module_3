<%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 04/06/2023
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="/user?action=edit&id=${userinfo.getId()}" method="post">
    <table>
        <caption><h3>Sửa User</h3></caption>
        <tr>
            <td><label for="name">Tên: </label></td>
            <td><input type="text" name="name" id="name" value="${userinfo.getName()}"></td>
        </tr>
        <tr>
            <td><label for="dob">Ngày sinh: </label></td>
            <td><input type="date" name="dob" id="dob" value="${userinfo.getDob()}"></td>
        </tr>
        <tr>
            <td><label for="address">Địa chỉ: </label></td>
            <td><input type="text" name="address" id="address" value="${userinfo.getAddress()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Sửa"></td>
        </tr>
    </table>
</form>
</body>
</html>
