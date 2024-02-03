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



/**
 * Servlet implementation class DangNhap
 */
@WebServlet(name = "dang-nhap", value = "/dang-nhap")
public class DangNhap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
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
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        //mã hóa mật khẩu
        String matKhauMaHoa = Encode.toSHA1(matKhau);


        KhachHang kh = new KhachHang();
        kh.setTenDangNhap(tenDangNhap);
        kh.setMatKhau(matKhauMaHoa);

        KhachHangDAO khd = new KhachHangDAO();

        KhachHang khachHang = khd.selectByUsernameAndPassWord(kh);
        String url = "";
        if(khachHang!=null) {
            // Người dùng hợp lệ, thiết lập session và chuyển hướng đến trang chính
            HttpSession session = request.getSession();
            session.setAttribute("khachHang", khachHang);
            url = "/index.jsp";
        }else {
            // Người dùng không hợp lệ, thông báo lỗi và chuyển hướng đến trang đăng nhập
            request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
            url = "/dangnhap.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("tenDangNhap");
        String password = request.getParameter("matKhau");
}
}