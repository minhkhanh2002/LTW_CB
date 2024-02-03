package com.nlu.fit.webcuoiky.controller;

import com.mysql.cj.protocol.x.Notice;
import com.nlu.fit.webcuoiky.Ulti.Check;
import com.nlu.fit.webcuoiky.Ulti.Encode;
import com.nlu.fit.webcuoiky.database.KhachHangDAO;
import com.nlu.fit.webcuoiky.model.KhachHang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;
@WebServlet(name = "dang-ky", value = "/dang-ky")
public class DangKy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKy() {
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

        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        String matKhauNhapLai = request.getParameter("matKhauNhapLai");
        String hoVaTen = request.getParameter("hoVaTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiKhachHang = request.getParameter("diaChiKhachHang");
        String diaChiMuaHang = request.getParameter("diaChiMuaHang");
        String diaChiNhanHang = request.getParameter("diaChiNhanHang");
        String dienThoai = request.getParameter("dienThoai");
        String email = request.getParameter("email");
        String dongYNhanMail = request.getParameter("dongYNhanMail");
        request.setAttribute("tenDangNhap", tenDangNhap);
        request.setAttribute("hoVaTen", hoVaTen);
        request.setAttribute("gioiTinh", gioiTinh);
        request.setAttribute("ngaySinh", ngaySinh);
        request.setAttribute("diaChiKhachHang", diaChiKhachHang);
        request.setAttribute("diaChiMuaHang", diaChiMuaHang);
        request.setAttribute("diaChiNhanHang", diaChiNhanHang);
        request.setAttribute("dienThoai", dienThoai);
        request.setAttribute("dongYNhanMail", dongYNhanMail);

        String url = "";

        String baoLoi = "";
        KhachHangDAO khachHangDAO = new KhachHangDAO();

        if (khachHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
            baoLoi += "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
        }

        if (!Check.kiemTraMatKhau(matKhau)) {
            baoLoi += "Mật khẩu tối thiểu 6 ký tự, bao gồm ít nhất một chữ cái in hoa, một chữ cái thường, và một chữ số.<br/>";
        }

        if (!matKhau.equals(matKhauNhapLai)) {
            baoLoi += "Mẫu khẩu không khớp.<br/>";
        } else {
            matKhau = Encode.toSHA1(matKhau);
        }

        request.setAttribute("baoLoi", baoLoi);


        if (baoLoi.length() > 0) {
            url = "/dangky.jsp";
        } else {
            Random rd = new Random();
            String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
            KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
            khachHangDAO.insert(kh);
            KhachHang khm = khachHangDAO.selectById(kh);
            request.getSession().setAttribute("khachHang", khm);
            url = "/thanhcong.jsp";

        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
