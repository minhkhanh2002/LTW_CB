package com.nlu.fit.webcuoiky.controller;

import com.nlu.fit.webcuoiky.database.KhachHangDAO;
import com.nlu.fit.webcuoiky.model.KhachHang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "khach-hang-servlet", value = "/khach-hang-servlet")
public class KhachHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maKhachHang = request.getParameter("maKhacHang");
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matkhau");
        String hoVaTen = request.getParameter("hoVaTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiKhachHang = request.getParameter("diaChiKhachHang");
        String diaChiMuaHang = request.getParameter("diaChiMuaHang");
        String diaChiNhanHang = request.getParameter("diaChiNhanHang");
        String dienThoai = request.getParameter("dienThoai");
        String email = request.getParameter("email");
        String dongYNhanMail = request.getParameter("dongYNhanMail");

        String baoLoi = "";
//        KhachHang khachHang = new KhachHang();
//        khachHang.setMaKhachHang(maKhachHang);
//        khachHang.setTenDangNhap(tenDangNhap);
//        khachHang.setMatKhau(matKhau);
//        khachHang.setHoVaTen(hoVaTen);
//        khachHang.setGioiTinh(gioiTinh);
//        khachHang.setNgaySinh(Date.valueOf(ngaySinh));
//        khachHang.setDiaChi(diaChiKhachHang);
//        khachHang.setDiaChiMuaHang(diaChiMuaHang);
//        khachHang.setDiaChiNhanHang(diaChiNhanHang);
//        khachHang.setSoDienThoai(dienThoai);
//        khachHang.setEmail(email);
//        khachHang.setDangKyNhanBangTin(dongYNhanMail!=null);

        KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
        khachHangDAO.insert(kh);
        baoLoi +="Thành Công!";
        String url = "/creatuser.jsp";



        //response.sendRedirect("");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
