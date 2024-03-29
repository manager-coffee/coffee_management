<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=user" class="btn btn-success">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table class="table">
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Number:</th>
                <td>
                    <input type="text" name="number" id="number" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <select name="country" id="country" >
                        <option value="Việt Nam" <c:if test="${user.address eq 'Việt Nam'}">selected</c:if>>Việt
                            Nam</option>
                        <option value="Mỹ" <c:if test="${user.address eq 'Mỹ'}">selected</c:if>>Mỹ</option>
                        <option value="Anh" <c:if test="${user.address eq 'Anh'}">selected</c:if>>Anh</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" style="color: #cce5ff">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>