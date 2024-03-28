<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coffee Shop</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .custom-btn {
            background-color: #007bff; /* Màu nền */
            color: black; /* Màu chữ */
            border: none; /* Loại bỏ đường viền */
            padding: 10px 20px; /* Kích thước lề */
            border-radius: 5px; /* Bo góc */
            cursor: pointer; /* Con trỏ chuột thành dấu tay */
            transition: background-color 0.3s ease; /* Hiệu ứng chuyển đổi màu nền */
        }
        .custom-btn:hover {
            background-color: firebrick; /* Màu nền hover */
        }
    </style>
</head>
<body>
<h1 class="head">COFFEE</h1>
<div id="menu">
    <ul>

        <li><a href="#">Trang chủ </a>
        </li>
        <li><a href="#">Sản phẩm</a>
            <ul>
                <li><a href="#">Coffee</a></li>
                <li><a href="#">Trà</a></li>
                <li><a href="#">Bánh Ngọt</a></li>
            </ul>
        </li>
        <li><a href="#">Giới thiệu</a></li>
        <li><a href="#">menu</a>
            <ul>
                <li><a href="/coffee?action=create">add product</a></li>
            </ul>
        </li>

    </ul>
</div>


<form href="/coffee" method="get">
    <hr>

    <hr>
    <c:forEach var="product" items="${product}">
        <tr>
            <div class="responsive">
                <div class="gallery">
                    <a target="_blank">
                        <img src="${product.image_url}" alt="Trolltunga Norway" width="300" height="200">
                    </a>
                    <div class="desc">${product.category_id}</div>
                    <div class="desc">${product.product_name}</div>
                    <div class="desc">${product.price}</div>
                    <div>
                        <a style="background-color: blue; color: white;"
                           href="#" role="button">Chỉnh sửa</a>
                    </div>

                </div>
            </div>

        </tr>

    </c:forEach>

        <!-- Nội dung ở đây -->


<%--        <div class="responsive" style="margin-top: 20px;">--%>
<%--            <button class="big-plus" style="width: 300px; height: 300px; float: left;">--%>
<%--               +--%>
<%--            </button>--%>
<%--        </div>--%>



</form>

</body>
</html>