<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 27/03/2024
  Time: 11:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add New Product</title>
    <!-- Thêm liên kết tới các tệp CSS của Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>

<body>
<div class="container">
    <h2>Add New Product</h2>
    <form href="/coffee" method="post"> <!-- Điều chỉnh action tùy theo URL của
    servlet xử lý form -->
        <div class="form-group">
            <label for="product_name">Product Name:</label><br>
            <input type="text" class="form-control" id="product_name" name="product_name" required><br>
        </div>

        <div class="form-group">
            <label for="price">Price:</label><br>
            <input type="number" class="form-control" id="price" name="price" required><br>
        </div>

        <div class="form-group">
            <label for="category_id">Category:</label><br>
            <select class="form-control" id="category_id" name="category_id">
                <c:forEach var="category" items="${category}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="image_url">Image URL:</label><br>
            <input type="text" class="form-control" id="image_url" name="image_url" required><br>
        </div>
<div class="text-center">
        <button type="submit" class="btn btn-primary">Submit</button>
</div>
    </form>
</div>
</body>
</html>


