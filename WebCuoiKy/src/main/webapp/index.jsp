<%@page import="com.nlu.fit.webcuoiky.model.KhachHang"%>
<%@ page import="com.nlu.fit.webcuoiky.model.SanPham" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="com.nlu.fit.webcuoiky.database.SanPhamDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nlu.fit.webcuoiky.database.TheLoaiDAO" %>
<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Bookstore</title>
  <style>
    .row.text-center {
      text-align: center;
    }
    .row {
      margin: 0; /* Loại bỏ margin mặc định của các thẻ div */
    }
    .row b {
      font-weight: bold;
    }
    .row a {
      text-decoration: none; /* Loại bỏ gạch chân mặc định của liên kết */
      color: #000; /* Màu văn bản của liên kết */
      display: inline-block; /* Hiển thị liên kết như một khối */
      padding: 5px 10px; /* Thêm padding cho liên kết */
      background-color: #eee; /* Màu nền cho liên kết */
      border-radius: 5px; /* Bo tròn các góc */
    }
    .row a:hover {
      background-color: #ddd; /* Màu nền khi di chuột qua liên kết */
    }
  </style>

  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="css/home.css">
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
          crossorigin="anonymous">
  <script
          src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
          integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
          crossorigin="anonymous"></script>
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
          integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
          crossorigin="anonymous"></script>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"> <img
            src="hhttps://thumbs.dreamstime.com/b/bookstore-bookshop-vector-sign-icon-symbol-emblem-logo-vintage-style-graphic-design-element-books-business-related-to-78505961.jpg"
            alt="LOGO" height="12">
    </a>
    <button class="navbar-toggler" type="button"
            data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active"
                                aria-current="page" href="#">Trang chủ</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Combo
          giảm giá</a></li>
        <li class="nav-item dropdown"><a
                class="nav-link dropdown-toggle" href="#" role="button"
                data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Truyện Tranh</a></li>
            <li><a class="dropdown-item" href="#">Văn Học Trong Nước</a></li>
            <li><a class="dropdown-item" href="#">Văn Học Nước Ngoài</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sách Tham Khảo</a></li>
          </ul></li>
        <li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
        </li>
      </ul>


      <!-- tìm kiếm -->


      <form class="d-flex" role="search" action="tim-kiem" method="post" accept-charset="UTF-8">
        <input class="form-control me-2" type="search" name="txt"
               placeholder="Nội dung tìm kiếm" aria-label="Search" accept-charset="UTF-8">
        <button class="btn btn-outline-success" type="submit">Tìm</button>



        <%
          Object obj = session.getAttribute("khachHang");
          KhachHang khachHang = null;
          if (obj!=null)
            khachHang = (KhachHang)obj;

          if(khachHang==null){

        %>

        <a class="btn btn-primary" style="white-space: nowrap;" href="dangnhap.jsp">
          Đăng nhập
        </a>
        <%} else { %>

        <ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
          <li class="nav-item dropdown dropstart"><a
                  class="nav-link dropdown-toggle" href="#" role="button"
                  data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
            <div><%=khachHang.getHoVaTen()%></div>
            <ul class="dropdown-menu">
              <% if(khachHang.getMaKhachHang().equals("1")){ %>
              <li><a class="dropdown-item" href="quanly.jsp">Quản Lý</a></li>
              <li><a class="dropdown-item" href="thaydoithongtin.jsp">Thay đổi thông tin</a></li>
              <li><a class="dropdown-item" href="doimatkhau.jsp">Đổi mật khẩu</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="dang-xuat">Đăng xuất</a></li>
              <% }else { %>
              <li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
              <li><a class="dropdown-item" href="thaydoithongtin.jsp">Thay đổi thông tin</a></li>
              <li><a class="dropdown-item" href="doimatkhau.jsp">Đổi mật khẩu</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="dang-xuat">Đăng xuất</a></li>
              <% }; %>
            </ul></li>
        </ul>

        <% } %>
      </form>
    </div>
  </div>
</nav>
<!-- End Navbar -->

<!-- Page content -->
<div class="container mt-4">
  <div class="row">
    <!-- Menu left -->
    <div class="col-lg-3">
      <div class="list-group ">
        <a href="#" class="list-group-item list-group-item-action">Sách Hay Nên Đọc </a>
        <a href="#" class="list-group-item list-group-item-action">Sản phẩm mới</a>
        <a href="#" class="list-group-item list-group-item-action">Sản phẩm bán chạy</a>
      </div>
    </div>
    <!-- End Menu left -->

    <!-- Slider and Products -->
    <div class="col-lg-9">
      <!-- Slider -->
      <div id="carouselExampleIndicators" class="carousel slide mb-4"
           data-bs-ride="true">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="0" class="active" aria-current="true"
                  aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://images.vexels.com/media/users/3/193703/raw/714f169d00d7ce76764c2186dc14eb62-read-a-book-slider-template.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://newshop.vn/public/uploads/landing-page/vanhoc/banner-van-hoc-kinh-dien.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://aeonmall-long-bien.com.vn/wp-content/uploads/2022/01/270275064_4487709871350969_6446081929055388732_n.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button"
                data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button"
                data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
      <!-- End Slider -->
      <!-- Products -->
      <% SanPhamDAO productDAO = new SanPhamDAO();
        TheLoaiDAO categoryDAO = new TheLoaiDAO();
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);%>


      <%
        request.setCharacterEncoding("UTF-8");
        String timKiem = request.getParameter("txt");
        if(request.getParameter("txt")==null){ %>
      <div class="body_page-trending-product-list">
        <% List<SanPham> list = new SanPhamDAO().selectAll1();
          for (SanPham p : list) {
        %>
        <div class="body_page-trending-product-list-card">
          <div class="card-image">
            <a href="product-detail?product_id=<%=p.getMaSanPham()%>"><img src="<%=p.getImage()%>"
                                                                           alt=""></a>
          </div>
          <div class="card-title-price">
            <p><%= p.getTenSanPham() %>
            </p>
            <span style="font-size: 15px"><%=p.getGiaBan()%></span>
            <span style="margin-left: 10px; color: #6c6c6c; font-size: 15px"><strike><%=p.getGiaGoc()%></strike></span>
          </div>
          <div class="card-btn">
            <button><a href="product-detail?product_id=<%=p.getMaSanPham()%>">Chi tiết</a></button>
            <button
                    onclick="addtocart(<%=p.getMaSanPham()%>)">Thêm vào giỏ
            </button>
          </div>
        </div>

        <% }  %>

      </div>
      <% } else { %>
      <div class="body_page-trending-product-list">
        <% List<SanPham> list = new SanPhamDAO().selectByName(timKiem);
          for (SanPham p : list) {
        %>
        <div class="body_page-trending-product-list-card">
          <div class="card-image">
            <a href="product-detail?product_id=<%=p.getMaSanPham()%>"><img src="<%=p.getImage()%>"
                                                                           alt=""></a>
          </div>
          <div class="card-title-price">
            <p><%= p.getTenSanPham() %>
            </p>
            <span style="font-size: 15px"><%=p.getGiaBan()%></span>
            <span style="margin-left: 10px; color: #6c6c6c; font-size: 15px"><strike><%=p.getGiaGoc()%></strike></span>
          </div>
          <div class="card-btn">
            <button><a href="product-detail?product_id=<%=p.getMaSanPham()%>">Chi tiết</a></button>
            <button
                    onclick="addtocart(<%=p.getMaSanPham()%>)">Thêm vào giỏ
            </button>
          </div>
        </div>

        <% } %>

      </div>
      <% } %>






      <!-- End Products -->
    </div>

    <!-- End Slider and Products -->
  </div>
</div>
<!-- End Page content -->

<!-- Footer -->
<footer class="py-3 my-4">
  <ul class="nav justify-content-center border-bottom pb-3 mb-3">
    <li class="nav-item"><a href="#"
                            class="nav-link px-2 text-muted">Trang chủ</a></li>
    <li class="nav-item"><a href="#"
                            class="nav-link px-2 text-muted">Quy định giao hàng</a></li>
    <li class="nav-item"><a href="#"
                            class="nav-link px-2 text-muted">Quy định trả hàng</a></li>
    <li class="nav-item"><a href="#"
                            class="nav-link px-2 text-muted">Liên hệ</a></li>
    <li class="nav-item"><a href="#"
                            class="nav-link px-2 text-muted">Blogs</a></li>
  </ul>
  <p class="text-center text-muted">© 2023 NLU</p>
</footer>
<!-- End footer -->


<div class="input-group mb-3">

  <div class="form-floating">
    <input type="text" class="form-control" id="floatingInputGroup1" placeholder="Username">
    <label for="floatingInputGroup1">Username</label>
  </div>

  <span class="input-group-text">@gmail.com</span>
</div>
</body>
</html>
