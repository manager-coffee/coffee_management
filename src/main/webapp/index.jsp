<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập Admin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url(https://cdn.tgdd.vn/2022/01/CookRecipe/CookUtensilandNotes/pha-ca-phe-espresso-bang-may-pha-ca-phe-tu-dong-note-1200x676.jpg); /* Đường dẫn của hình nền */
            background-size: cover;
            background-repeat: no-repeat;
        }
        .container {
            margin-top: 100px;
            width: 30%;
            margin-left: auto;
            margin-right: auto;
            background-color: rgba(255, 255, 255, 0.8); /* Màu nền với độ trong suốt */
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Đăng nhập Admin</h1>
    <form action="login" method="post">
        <div class="form-group">
            <label for="username">Tên người dùng:</label>
            <input type="text" id="username" name="username" required value="${username}">
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required value="${password}">
        </div>
        <input type="submit" value="Đăng nhập">
    </form>
    <div class="text-danger">${message}</div>
</div>
</body>
</html>