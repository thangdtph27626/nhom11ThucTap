<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Color List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #3498db;
        }

        a:hover {
            color: #2980b9;
        }

        a.button {
            display: inline-block;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a.button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h2>Color List</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>gender</th>
        <th>Price</th>
        <th>Quanlity</th>

        <th>Status</th>
        <th>Category</th>
        <th>Product</th>
        <th>Color</th>
        <th>Size</th>
        <th>Form</th>

        <th>Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product_detail" items="${product_details}">
        <tr>
            <td>${product_detail.id}</td>
            <td>${product_detail.description}</td>
            <td>${product_detail.gender}</td>
            <td>${product_detail.price}</td>
            <td>${product_detail.quantity}</td>
            <td>${product_detail.status}</td>
            <td>${product_detail.category.name}</td>
            <td>${product_detail.product.name}</td>
            <td>${product_detail.color.name}</td>
            <td>${product_detail.size.name}</td>
            <td>${product_detail.form.name}</td>
            <td>
                <a href="/product-detail/update/${product_detail.id}">Update</a>
                <a href="/product-detail/delete/${product_detail.id}">Delete</a>
                <a href="/product-detail/upload/${product_detail.id}">Upload ảnh</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/product-detail/view-add">Add Product_detail</a>
</body>
</html>
