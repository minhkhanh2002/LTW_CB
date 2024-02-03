package com.nlu.fit.webcuoiky.controller;


import com.nlu.fit.webcuoiky.database.SanPhamDAO;
import com.nlu.fit.webcuoiky.model.SanPham;
import com.nlu.fit.webcuoiky.model.TacGia;
import com.nlu.fit.webcuoiky.model.TheLoai;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Servlet implementation class DangXuat
 */

@WebServlet(name = "creat-servlet", value = "/creat-servlet")
public class CreatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatServlet() {
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

        String tenSanPham = request.getParameter("tenSanPham");
        String namXuatBan = request.getParameter("namXuatBan");
        String giaNhap = request.getParameter("giaNhap");
        String giaGoc = request.getParameter("giaGoc");
        String giaBan = request.getParameter("giaBan");
        String soLuong =request.getParameter("soLuong");
        String image = request.getParameter("image");
        String ngonNgu = request.getParameter("ngonNgu");
        String moTa = request.getParameter("moTa");
        String theLoai = request.getParameter("theLoai");
        Random rd = new Random();
        String maSanPham= System.currentTimeMillis() + rd.nextInt(1000) + "";

        SanPham sp = new SanPham(maSanPham,tenSanPham,new TacGia(),namXuatBan,giaNhap,giaGoc,giaBan,soLuong,new TheLoai(),ngonNgu,moTa,image);
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.insert(sp);

        String thongBao = "";
        String url = "";
        url = "/quanly.jsp";
        thongBao +="Đã thêm thành công!";
        request.setAttribute("thongBao", thongBao);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

