<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 1/26/2024
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Báo - Chưa Đăng Nhập</title>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            color: #333;
        }

        p {
            color: #555;
            margin-bottom: 20px;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        li {
            margin: 10px 0;
        }

        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>

<h1>Xin chào, bạn chưa đăng nhập hoặc không có quyền truy cập!</h1>

<p>Vui lòng chọn một trong những lựa chọn sau:</p>

<ul>
    <li><a href="dangky.jsp">Nếu chưa có tài khoản, hãy đăng ký tại đây</a></li>
    <li><a href="index.jsp">Quay lại trang chủ</a></li>
</ul>

</body>
</html>

