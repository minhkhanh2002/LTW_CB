<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px #000000;
            padding: 20px;
            margin-top: 50px;
        }
        .logo-container {
            text-align: center;
        }
        .logo-container img {
            max-width: 100%;
            max-height: 150px; /* Điều chỉnh kích thước theo ý muốn */
            margin-bottom: 20px;
        }
        .red {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="logo-container">
        <img alt="Ảnh LoGo" src="https://images.vexels.com/media/users/3/150469/raw/8b434a38a07aa9a18c988088cca1dccc-book-store-logo-template.jpg">
    </div>
    <%
        String baoLoi =request.getAttribute("baoLoi")+"";

        if (baoLoi.equals("null")){
            baoLoi = "";
        }

    %>
    <div class="text-center"> <span class="red"> <%=baoLoi %></span></div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center">Đăng nhập</h2>


            <form action="/dang-nhap" method="post">
                <div class="form-group">
                    <label for="tenDangNhap">Tên người dùng:</label>
                    <input type="text" class="form-control" name="tenDangNhap" id="tenDangNhap" required>
                </div>
                <div class="form-group">
                    <label for="matKhau">Mật khẩu:</label>
                    <input type="password" class="form-control" name="matKhau" id="matKhau"  required>
                </div>
                <div class="checkbox mb-3">
                    <label> <input type="checkbox" value="remember-me">
                        Ghi nhớ tài khoản.
                    </label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>

            </form>
            <p class="mt-3 text-center">Chưa có tài khoản? <a href="dangky.jsp">Đăng ký ngay</a></p>
            <p class="mt-3 text-center">Quên mật khẩu? <a href="quenmatkhau.jsp">Tìm lại ngay</a></p>
            <p class="mt-2 text-center">Đăng nhập bằng:
                <a href="google-login">Google</a> |
                <a href="facebook-login">Facebook</a>
            </p>
        </div>
    </div>
</div>

</body>
</html>
