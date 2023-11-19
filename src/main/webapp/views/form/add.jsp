<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Color</title>
    <!-- Include Select2 CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />

    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- Include Select2 JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>

    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>Add Color</h2>

<form:form  action="/form/add" method="post" modelAttribute="form">

<%--    <label for="code">Code:</label>--%>
<%--    <form:input path="code" id="code" name="code" required="true"/>--%>

    <label for="name">Name:</label>
    <form:input path="name" id="name" name="name" required="true"/>

    <%--    <label for="status">Status:</label>--%>
    <%--    <form:select path="status" id="status" name="status" style="width: 100%;">--%>
    <%--        <form:option value="ACTIVE">Active</form:option>--%>
    <%--        <form:option value="INACTIVE">Inactive</form:option>--%>
    <%--        <form:option value="PENDING">Pending</form:option>--%>
    <%--    </form:select>--%>

    <button type="submit">Add Form</button>

</form:form>

<!-- Initialize Select2 -->
<script>
    $(document).ready(function() {
        $('#status').select2();
    });
</script>

</body>
</html>
