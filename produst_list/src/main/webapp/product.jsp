<%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 05/06/2023
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product</title>
    <style>
        table {
            border: 1px solid;
        }
        tr,th,td {
            border: 1px solid;
        }
    </style>
</head>
<body>
<table>
    <a href="/products?action=add">Create</a>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.category}</td>
            <td>
                <a href="/products?action=edit&id=${product.id}">
                    <button>Edit</button>
                </a>
                <a onclick="return confirm('Do you want delete this ${product.name}?')"
                   href="/products?action=delete&id=${product.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
