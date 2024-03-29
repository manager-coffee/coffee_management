<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-3">
    <h2>List of Orders</h2>
    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Customer ID</th>
            <th>Order Date</th>
            <th>Order Status</th>
            <th>Total Amount</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.customerId}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderStatus}</td>
                <td>${order.totalAmount}</td>
                <td>
                    <a href="orders?action=edit&id=${order.orderId}" class="btn btn-warning">Edit</a>
                    <a href="orders?action=delete&id=${order.orderId}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
