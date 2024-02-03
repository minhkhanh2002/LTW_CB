package com.nlu.fit.webcuoiky.controller;

import com.nlu.fit.webcuoiky.database.KhachHangDAO;
import com.nlu.fit.webcuoiky.database.SanPhamDAO;
import com.nlu.fit.webcuoiky.model.KhachHang;
import com.nlu.fit.webcuoiky.model.SanPham;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "quan-ly", value = "/quan-ly")
public class QuanLy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLy() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thực hiện logic xử lý ở đây
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        KhachHang kh = (KhachHang) session.getAttribute("khachHang");
        String role = kh.getMaKhachHang();


        SanPhamDAO spd = new SanPhamDAO();
        List<SanPham> list = spd.selectAll1();

        request.setAttribute("listP", list);
        request.getRequestDispatcher("test.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
