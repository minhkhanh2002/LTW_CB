<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tạo Tài Khoản</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<%
    String baoLoi = request.getAttribute("baoLoi")+"";
    baoLoi = (baoLoi.equals("null"))?"":baoLoi;


    String tenDangNhap= request.getAttribute("tenDangNhap")+"";
    tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;

    String hoVaTen= request.getAttribute("hoVaTen")+"";
    hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;

    String gioiTinh= request.getAttribute("gioiTinh")+"";
    gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;

    String ngaySinh= request.getAttribute("ngaySinh")+"";
    ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;

    String diaChiKhachHang= request.getAttribute("diaChiKhachHang")+"";
    diaChiKhachHang = (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;

    String diaChiMuaHang= request.getAttribute("diaChiMuaHang")+"";
    diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;

    String diaChiNhanHang= request.getAttribute("diaChiNhanHang")+"";
    diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;

    String dienThoai= request.getAttribute("dienThoai")+"";
    dienThoai = (dienThoai.equals("null"))?"":dienThoai;

    String email= request.getAttribute("email")+"";
    email = (email.equals("null"))?"":email;

    String dongYNhanMail= request.getAttribute("dongYNhanMail")+"";
    dongYNhanMail = (dongYNhanMail.equals("null"))?"":dongYNhanMail;
%>
<div class="container">
    <h2>Create New User</h2>
    <form action="khach-hang-servlet" method="post">
        <div>
        <label for="maKhachHang">Mã Khách Hàng:</label>
        <input type="text" name="maKhachHang" required><br>
        </div>
        <label for="tenDangNhap">Tên Đăng Nhập</label>
        <input type="text" name="tenDangNhap" required value="<%=tenDangNhap%>"><br>

        <label for="matKhau">Mật Khẩu</label>
        <input type="password" name="matKhau" required><br>

        <label for="hoVaTen">Họ Và Tên:</label>
        <input type="text" name="hoVaTen"  value="<%=hoVaTen%>"><br>

        <label for="gioiTinh" >Giới tính</label> <select
            class="form-control" id="gioiTinh" name="gioiTinh">
        <option></option>
        <option value="Nam"
                <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %>>Nam</option>
        <option value="Nữ"
                <%=(gioiTinh.equals("Nữ"))?"selected='selected'":"" %>>Nữ</option>
        <option value="Khác"
                <%=(gioiTinh.equals("Khác"))?"selected='selected'":"" %>>Khác</option>
        </select>

        <label for="diaChi">Địa Chỉ:</label>
        <input type="text" name="diaChi"value="<%=diaChiKhachHang%>" ><br>

        <label for="diaChiMuaHang">Địa Chỉ Mua Hàng:</label>
        <input type="text" name="diaChiMuaHang" value="<%=diaChiMuaHang%>"><br>

        <label for="diaChiNhanHang">Địa Chỉ Nhận Hàng:</label>
        <input type="text" name="diaChiNhanHang" value="<%=diaChiNhanHang%>" ><br>

        <div class="mb-3">
            <label for="ngaySinh" >Ngày sinh</label> <input
                type="date"  id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>">
        </div>

        <label for="dienThoai">Số Điện Thoại:</label>
        <input type="text" name="dienThoai" value="<%=dienThoai%>" ><br>

        <label for="email">Email:</label>
        <input type="text" name="email" value="<%=email%>" ><br>

        <div class="mb-3">
            <label for="dongYNhanMail" >Nhận Mail Quảng Cáo:</label> <input type="checkbox" class="form-check-input"
                                     id="dongYNhanMail" name="dongYNhanMail">
        </div>


        <button type="submit">Create User</button>
    </form>
</div>
</body>
</html>

