<%@ page import="com.nlu.fit.webcuoiky.model.SanPham" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nlu.fit.webcuoiky.database.SanPhamDAO" %>
<%@ page import="com.nlu.fit.webcuoiky.model.KhachHang" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quản Lý</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        img{
            width: 200px;
            height: 120px;
        }
    </style>
    <script>
        String message = (String)request.getAttribute("message");
        if (!message.isEmpty()) {
        alert("message");
    </script>
<body>

<%
    Object obj = session.getAttribute("khachHang");
    KhachHang khachHang = null;
    if (obj!=null)
        khachHang = (KhachHang)obj;
    if(khachHang==null){

        response.sendRedirect("/chuadangnhap.jsp");
//    }else { if(!khachHang.getMaKhachHang().equals("admin")){
//
//        response.sendRedirect("/chuadangnhap.jsp");
    }else {

%>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">

                <div class="col-sm-6">

                    <h2>Manage <b>Product</b></h2>

                </div>

                    <div class="col-sm-6">
                    <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                </div>
            </div>
        </div>
        <%
        String thongBao = request.getAttribute("thongBao")+"";
        thongBao = (thongBao.equals("null"))?"":thongBao;%>
        <%=thongBao %>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                </th>
                <th>ID</th>
                <th>Tên</th>
                <th>Ảnh</th>
                <th>Price</th>
                <th>Số Lượnng</th>
                <th>Tùy Chọn</th>
            </tr>
            </thead>
            <tbody>
            <% List<SanPham> list = new SanPhamDAO().selectAll1();
                for (SanPham p : list) {
            %>
            <tr>
                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                </td>
                <td><%=p.getMaSanPham()%></td>
                <td><%=p.getTenSanPham()%></td>
                <td>
                    <img src="<%=p.getImage()%>">
                </td>
                <td>$<%=p.getGiaBan()%></td>
                <td>$<%=p.getSoLuong()%></td>
                <td>
                    <a href="#editEmployeeModal"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div class="clearfix">
        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
        <ul class="pagination">
            <li class="page-item disabled"><a href="#">Previous</a></li>
            <li class="page-item"><a href="#" class="page-link">1</a></li>
            <li class="page-item"><a href="#" class="page-link">2</a></li>
            <li class="page-item active"><a href="#" class="page-link">3</a></li>
            <li class="page-item"><a href="#" class="page-link">4</a></li>
            <li class="page-item"><a href="#" class="page-link">5</a></li>
            <li class="page-item"><a href="#" class="page-link">Next</a></li>
        </ul>
    </div>
</div>
<a href="#"><button type="button" class="btn btn-primary">Back to home</button>

</a>


<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="creat-servlet" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên Sách</label>
                        <input name="tenSanPham" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Năm Xuất Bản</label>
                        <input name="namXuatBan" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Giá Nhập</label>
                        <input name="giaNhap" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Giá Gốc</label>
                        <input name="giaGoc" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Giá Bán</label>
                        <input name="giaBan" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Số Lượng</label>
                        <input name="soLuong" type="text" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input name="image" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Ngôn Ngữ</label>
                        <input name="ngonNgu" type="text" class="form-control" >
                    </div>

                    <div class="form-group">
                        <label>Mô Tả</label>
                        <textarea name="moTa" class="form-control" ></textarea>
                    </div>
                    <div class="form-group">
                        <label>Thể Loại</label>
                        <select name="theLoai" class="form-select" aria-label="Default select example">
                            <option value="TL01">Văn Học Trong Nước</option>
                            <option value="TL02">Văn Học Nước Ngoài</option>
                            <option value="TL03">Sách Tham Khảo</option>
                            <option value="TL04">Truyện Tranh</option>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>

</a>
<script src="js/manager.js" type="text/javascript"></script>
<%} %>
</body>

</html>
