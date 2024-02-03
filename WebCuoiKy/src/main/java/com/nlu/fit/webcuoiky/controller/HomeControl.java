package com.nlu.fit.webcuoiky.controller;

import com.nlu.fit.webcuoiky.database.SanPhamDAO;
import com.nlu.fit.webcuoiky.model.SanPham;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "home-control", value = "/homecontrol")
public class HomeControl extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        //b1:lấy data từ SanPhamDAO
        SanPhamDAO spd = new SanPhamDAO();
        List<SanPham> list = spd.selectAll1();
        //b2: set data to jsp
        request.setAttribute("listAllProduct", list);
        request.getRequestDispatcher("ndex.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // TODO Auto-generated method stub
        doGet(request, response);
    }




}