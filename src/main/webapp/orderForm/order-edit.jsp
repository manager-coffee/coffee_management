<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Order</title>
    <!-- Thêm Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2 class="mt-5">Edit Order</h2>
    <form action="${pageContext.request.contextPath}/orders" method="post" class="mt-3">
        <input type="hidden" name="id" value="${order.orderId}" />

        <div class="form-group">
            <label for="productId">Product ID:</label>
            <input type="text" id="productId" name="productId" class="form-control" value="${order.productId}" required/>
        </div>

        <div class="form-group">
            <label for="customerId">Customer ID:</label>
            <input type="text" id="customerId" name="customerId" class="form-control" value="${order.customerId}" required/>
        </div>

        <div class="form-group">
            <label for="date">Order Date:</label>
            <input type="date" id="date" name="orderDate" class="form-control" value="${order.orderDate}" required/>
        </div>

        <div class="form-group">
            <label for="status">Order Status:</label>
            <input type="text" id="status" name="orderStatus" class="form-control" value="${order.orderStatus}" required/>
        </div>

        <div class="form-group">
            <label for="total">Total Amount:</label>
            <input type="number" id="total" name="totalAmount" class="form-control" value="${order.totalAmount}" required/>
        </div>

        <input type="submit" name="action" value="update" />
    </form>
</div>

</body>
</html>
