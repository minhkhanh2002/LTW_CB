<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .recovery-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }
        .red {
            color: red;
        }
    </style>
</head>
<body>

<div class="recovery-container">
    <h2>Lấy Lại Mật Khẩu</h2>
    <%
        String baoLoi =request.getAttribute("baoLoi")+"";

        if (baoLoi.equals("null")){
            baoLoi = "";
        }

    %>
    <div class="text-center"> <span class="red"> <%=baoLoi %></span></div>

    <form action="quen-mat-khau" method="post">
        <input type="text" id="tenDangNhap" name="tenDangNhap" placeholder="Nhập tên đăng nhập của bạn..." ><br>
        <p>Hoặc</p>
        <input type="email" id="email" name="email" placeholder="Nhập email của bạn..." ><br>
        <button type="submit">Lấy lại mật khẩu</button>
    </form>

    <p class="error-message">....</p>
</div>

</body>
</html>

