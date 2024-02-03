package com.nlu.fit.webcuoiky.controller;

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
import java.io.PrintWriter;

@WebServlet(name = "doiMatKhau", value = "/doi-mat-khau")
public class DoiMatKhau extends HttpServlet {
    public DoiMatKhau(){

        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String matKhauHienTai = request.getParameter("matKhauHienTai");
        String matKhauMoi = request.getParameter("matKhauMoi");
        String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");

        String matKhauHienTaiSha1 = Encode.toSHA1(matKhauHienTai);

        String baoLoi = "";
        String url="";

        //check trùng khớp mật khẩu cũ
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("khachHang");
        KhachHang khachHang = null;
         if (obj!=null){
             khachHang = (KhachHang) obj;
             //kiểm tra đăng nhập
             if(khachHang == null){
                 baoLoi = "Bạn Chưa Đăng Nhập!";
                 url ="/index.jsp";
             } else {
                 // Đã đăng nhập
                 if (!matKhauHienTaiSha1.equals(khachHang.getMatKhau())){
                     baoLoi = "Mật Khẩu Hiện Tại Không Chính Xác!";
                     url ="/doimatkhau.jsp";
                 } else {
                     if (!matKhauMoi.equals(matKhauMoiNhapLai)){
                         baoLoi = "Mật Khẩu Mới Không Khớp!";
                         url ="/doimatkhau.jsp";
                     } else {
                         String matKhauMoi_Sha1 = Encode.toSHA1(matKhauMoi);
                         khachHang.setMatKhau(matKhauMoi_Sha1);
                         KhachHangDAO khd = new KhachHangDAO();
                         if (khd.changePassword(khachHang)){
                             baoLoi = "Thay Đổi Mật Khẩu Thành Công!";
                             url ="/doimatkhau.jsp";
                         } else {
                             baoLoi = "Đổi Mật Khẩu Thất Bại";

                         }
                     }

                 }
             }
         }

        request.setAttribute("baoLoi", baoLoi);
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
