<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            border: 1px solid;
        }
        tr, th,td {
            border: 1px solid;
        }
        img {
            width: 40px;
            height: 40px;
        }
    </style>
    <title>List User</title>
</head>
<body>
    <c:if test="${message != null}">
        <h4>${message}</h4>
    </c:if>
    <table>
        <caption><h1>Danh Sách Khách Hàng</h1></caption>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getDob()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getImg()}</td>
                <td>
                    <a href="/user?action=edit&id=${user.getId()}"><button>Edit</button></a>
                   <button onclick="delete_user(${user.getId()})">Delete</button>
                </td>
            </tr>
        </c:forEach>
        <tr></tr>
    </table>
    <a href="/create_user.jsp"><button>Create New User</button></a>
    <script>
        function delete_user(id) {
            let text = "Bạn muốn xóa tài người dùng này?";
            if (confirm(text))
                document.location.href="user?action=delete&id="+id;
        }
    </script>
</body>
</html>