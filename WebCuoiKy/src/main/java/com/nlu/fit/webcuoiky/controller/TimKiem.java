package com.nlu.fit.webcuoiky.controller;


import com.nlu.fit.webcuoiky.database.SanPhamDAO;
import com.nlu.fit.webcuoiky.model.SanPham;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Servlet implementation class DangXuat
 */

@WebServlet(name = "tim-kiem", value = "/tim-kiem")
public class TimKiem extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiem() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String txtSearch = request.getParameter("txt");
        SanPhamDAO spd = new SanPhamDAO();
        List<SanPham> list = spd.selectByName(txtSearch);

        request.setAttribute("listP",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
