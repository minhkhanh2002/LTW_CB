<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký Thành Công</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background: url('https://img4.thuthuatphanmem.vn/uploads/2020/07/30/background-mau-xanh-khai-giang-truong-hoc_024037383.jpg') no-repeat center center fixed;
            background-size: cover;
        }

        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #28a745;
        }

        p {
            color: #333;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Chúc mừng bạn đã đăng ký tài khoản thành công!</h1>
    <p>Vui lòng quay lại trang đăng nhập.</p>

    <!-- Tự động chuyển hướng sau 3 giây -->
    <script>
        setTimeout(function() {
            window.location.href = 'index.jsp';
        }, 3000);
    </script>
</div>
</body>
</html>
