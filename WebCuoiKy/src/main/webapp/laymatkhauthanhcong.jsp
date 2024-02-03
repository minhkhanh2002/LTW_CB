<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Recovery Success</title>
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
            text-align: center;
        }

        .success-container {
            background-color: #4caf50;
            color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        p {
            margin: 0;
        }
    </style>
</head>
<body>

<div class="success-container">
    <h2>Lấy Lại Mật Khẩu Thành Công</h2>
    <p>Mật khẩu đã được gửi đến email của bạn.</p>
    <p>Vui lòng kiểm tra và đăng nhập!</p>
</div>

<script>
    setTimeout(function(){
        window.location.href = "index.jsp";
    }, 3000); // Redirect to index.jsp after 3 seconds
</script>

</body>
</html>
