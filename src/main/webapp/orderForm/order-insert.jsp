<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Create New Order</h2>
    <form action="orders" method="post">

        <input type="hidden" name="action" value="insert">

        <div class="form-group">
            <label for="users">Select a users:</label>
            <select id="users" name="productId">
                <c:forEach items="${services}" var="service">
                    <option value="${service.id}">${service.id}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Order Date:</label>
            <input type="date" name="orderDate" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Order Status ID:</label>
            <input type="number" name="orderStatusId" class="form-control">
        </div>

        <div class="form-group">
            <label>Total Amount:</label>
            <input type="text" name="totalAmount" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="product">Select a product:</label>
            <select id="product" name="productId">
                <c:forEach items="${products}" var="product">
                    <option value="${product.product_id}">${product.product_name}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
