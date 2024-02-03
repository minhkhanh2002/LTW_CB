package com.nlu.fit.webcuoiky.controller;



import com.nlu.fit.webcuoiky.Ulti.EmailService;
import com.nlu.fit.webcuoiky.Ulti.Encode;
import com.nlu.fit.webcuoiky.Ulti.IJavaMail;
import com.nlu.fit.webcuoiky.database.KhachHangDAO;
import com.nlu.fit.webcuoiky.model.KhachHang;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;


/**
 * Servlet implementation class DangNhap
 */
@WebServlet(name = "quen-mat-khau", value = "/quen-mat-khau")
public class QuenMatKhau extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuenMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cấu hình gửi mail
        final  String username = "shoponline.edu@gmail.com";
        final String password = "Minhkhanh2002";
        Properties prop = new Properties();
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });



        String tenDangNhap = request.getParameter("tenDangNhap");
        String email= request.getParameter("email");
        System.out.println("Ten dang nhap:"+tenDangNhap);
        System.out.println("Email:"+email);
        //tạo mật khẩu mới
        Random random = new Random();
        StringBuilder matKhauMoiBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            matKhauMoiBuilder.append(random.nextInt(10));
        }

        String baoLoi = null;

        if (tenDangNhap!=""){
            KhachHang kh = new KhachHang();
            kh.setTenDangNhap(tenDangNhap);
            KhachHangDAO khd = new KhachHangDAO();
            KhachHang khachHang = khd.selectByUsername(kh);
            String url = "";
            if(khachHang!=null) {
                // Có người dùng
                String mailTo = khachHang.getEmail();
                String mailSubject = "Lấy lại mật khẩu";

                String matKhauMoi = matKhauMoiBuilder.toString();

                String matKhauMoi_Sha1 = Encode.toSHA1(matKhauMoi);
                khachHang.setMatKhau(matKhauMoi_Sha1);

                khd.changePassword(khachHang);

                String mailContent = "Mật khẩu của bạn là: "+ matKhauMoi;
                System.out.println("mat khau moi : "+matKhauMoi);
                //gửi mail
                IJavaMail emailService = new EmailService();
                emailService.send(mailTo,mailSubject,mailContent);

                url = "/laymatkhauthanhcong.jsp";
            }else {
                // Người dùng không hợp lệ, thông báo lỗi và chuyển hướng đến trang đăng nhập
                request.setAttribute("baoLoi", "Không tìm thấy người dùng");
                url = "/quenmatkhau.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } else  {
            KhachHang kh = new KhachHang();
            kh.setEmail(email);
            KhachHangDAO khd = new KhachHangDAO();
            KhachHang khachHang = khd.selectByEmail(kh);
            String url = "";
            if(khachHang!=null) {
                // Có người dùng
                // Có người dùng
                String mailTo = khachHang.getEmail();
                String mailSubject = "Lấy lại mật khẩu";

                String matKhauMoi = matKhauMoiBuilder.toString();

                String matKhauMoi_Sha1 = Encode.toSHA1(matKhauMoi);
                khachHang.setMatKhau(matKhauMoi_Sha1);

                khd.changePassword(khachHang);

                String mailContent = "Mật khẩu của bạn là: "+ matKhauMoi;
                System.out.println("mat khau moi : "+matKhauMoi);
                //gửi mail
                IJavaMail emailService = new EmailService();
                emailService.send(mailTo,mailSubject,mailContent);
                url = "/laymatkhauthanhcong.jsp";
            }else {
                // Người dùng không hợp lệ, thông báo lỗi và chuyển hướng đến trang đăng nhập
                request.setAttribute("baoLoi", "Không tìm thấy người dùng");
                url = "/quenmatkhau.jsp";
            }


            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("tenDangNhap");
        String password = request.getParameter("matKhau");
    }
}