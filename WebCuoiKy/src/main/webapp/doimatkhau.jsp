<%@page import="com.nlu.fit.webcuoiky.model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đổi Mật Khẩu</title>
    <style>
        span.error-message {
            color: red;
        }
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

        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        h1 {
            color: #333;
        }

        label {
            display: block;
            margin: 10px 0;
        }

        input {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        button {
            background-color: #28a745;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%
    Object obj = session.getAttribute("khachHang");
    KhachHang khachHang = null;
    if (obj!=null)
        khachHang = (KhachHang)obj;
    if(khachHang==null){
%>


<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>

<form action="index.jsp" method="get">
    <p>
        <button type="submit">Quay về Trang Chủ</button>
    </p>
</form>

<%
}else {
    String baoLoi = request.getAttribute("baoLoi")+"";
    if(baoLoi.equals("null")){
        baoLoi = "";
    }
%>



<div class="container">
    <h1>Đổi Mật Khẩu</h1>
    <span  class="error-message">
        <%=baoLoi %>
    </span>
    <form action="doi-mat-khau" method="post" id="changePasswordForm">
        <label for="matKhauHienTai">Mật khẩu hiện tại:</label>
        <input type="password" id="matKhauHienTai" name="matKhauHienTai" required>

        <label for="matKhauMoi">Mật khẩu mới:</label>
        <input type="password" id="matKhauMoi" name="matKhauMoi" required>

        <label for="matKhauMoiNhapLai">Xác nhận mật khẩu mới:</label>
        <input type="password" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai" required>

        <button type="submit">Đổi Mật Khẩu</button>


    </form>
    <form action="index.jsp" method="get">
        <p>
            <button type="submit">Quay về Trang Chủ</button>
        </p>
    </form>
</div>
<%
}
%>

</body>
</html>
