<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Page Title</title>
</head>
<body>
<%-- Hiển thị thông điệp nếu tồn tại --%>
<c:if test="${not empty message}">
    <div style="color:red;">
            ${message}
    </div>
</c:if>

<%-- Phần còn lại của trang --%>
</body>
</html>
