<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:if test="${not empty sessionScope.message}">
    <div class="alert alert-success" role="alert">
            ${sessionScope.message}
    </div>
    <%
        session.removeAttribute("message");
    %>
</c:if>


<div class="container mt-4">
    <h2>List of Orders</h2>
    <!-- Nút Tạo Mới Đơn Hàng -->
    <div class="my-3">
        <a href="orders?action=new" class="btn btn-success">Create New Order</a>
    </div>

    <!-- Ô Tìm Kiếm -->
    <form class="form-inline mb-3" action="orders" method="get">
        <input type="hidden" name="action" value="search"/>
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchQuery">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

    <!-- Bảng Đơn Hàng -->
    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th><a href="?sortBy=order_id&sortDirection=${sortDirection == 'ASC' ? 'DESC' : 'ASC'}">ID</a></th>
            <th><a href="?sortBy=customer_id&sortDirection=${sortDirection == 'ASC' ? 'DESC' : 'ASC'}">Customer ID</a></th>
            <th><a href="?sortBy=order_date&sortDirection=${sortDirection == 'ASC' ? 'DESC' : 'ASC'}">Order Date</a></th>
            <th><a href="?sortBy=order_status_id&sortDirection=${sortDirection == 'ASC' ? 'DESC' : 'ASC'}">Order Status</a></th>
            <th><a href="?sortBy=total_amount&sortDirection=${sortDirection == 'ASC' ? 'DESC' : 'ASC'}">Total Amount</a></th>
            <th><a href="?sortBy=product_id&sortDirection=${sortDirection == 'ASC' ? 'DESC' : 'ASC'}">ProductID</a></th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.order_id}</td>
                <td>${order.customer_id}</td>
                <td>${order.order_date}</td>
                <td>${order.order_status_id}</td>
                <td>${order.total_amount}</td>
                <td>${order.product_id}</td>
                <td><a href="orders?action=edit&id=${order.order_id}" class="btn btn-warning">Edit</a></td>
                <td><a href="orders?action=delete&id=${order.order_id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
