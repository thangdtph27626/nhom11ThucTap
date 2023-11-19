<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD Cua Hang</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<sf:form action="/product-detail/update" method="post"
         modelAttribute="VM">
    <div>
        <label>description</label>
        <sf:input path="description"/>
        <sf:errors path="description"/>
    </div>
    <div>
        <label>price</label>
        <sf:input path="price"/>
        <sf:errors path="price"/>
    </div>
    <div>
        <label> quantity</label>
        <sf:input path="quantity"/>
        <sf:errors path="quantity"/>
    </div>

    <div>
        <label> product</label>
        <form:select path="idProduct">
            <c:forEach items="${product}" var="product">
                <form:option value="${product.id}">${product.name}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div>
        <label>category</label>
        <form:select path="idCategory">
            <c:forEach items="${category}" var="category">
                <form:option value="${category.id}">${category.name}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div>
        <label>color</label>
        <form:select path="idColor">
            <c:forEach items="${color}" var="color">
                <form:option value="${color.id}">${color.name}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div>
        <label>size</label>
        <form:select path="idSize">
            <c:forEach items="${size}" var="size">
                <form:option value="${size.id}">${size.name}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div>
        <label>form</label>
        <form:select path="idForm">
            <c:forEach items="${form}" var="form">
                <form:option value="${form.id}">${form.name}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <button type="submit">Thêm</button>
</sf:form>
</body>
</html>
