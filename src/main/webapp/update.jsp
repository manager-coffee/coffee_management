<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
    <!-- Thêm liên kết tới các tệp CSS của Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h2>Chỉnh sửa Sản phẩm</h2>
    <form href="/coffee" method="post"> <!-- Điều chỉnh action tùy theo URL của servlet xử lý form -->
        <div class="form-group">
            <label for="product_name">Tên Sản phẩm:</label><br>
            <input type="text" class="form-control" id="product_name" name="product_name" value="${product.product_name}" required><br>
        </div>

        <div class="form-group">
            <label for="price">Giá:</label><br>
            <input type="number" class="form-control" id="price" name="price" value="${product.price}" required><br>
        </div>

        <div class="form-group">
            <label for="category_id">Danh mục:</label><br>
            <select class="form-control" id="category_id" name="category_id">
                <c:forEach var="category" items="${category}">
                    <option value="${category.id}" >${category.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="image_url">URL Hình ảnh:</label><br>
            <input type="text" class="form-control" id="image_url" name="image_url" value="${product.image_url}" required><br>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
