package com.nlu.fit.webcuoiky.controller;

import java.io.*;
import java.sql.Date;
import java.util.Random;

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


@WebServlet(name = "thay-doi-thong-tin", value = "/thay-doi-thong-tin")
public class ThayDoiThongTin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String hoVaTen = request.getParameter("hoVaTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiKhachHang = request.getParameter("diaChiKhachHang");
        String diaChiMuaHang = request.getParameter("diaChiMuaHang");
        String diaChiNhanHang = request.getParameter("diaChiNhanHang");
        String dienThoai = request.getParameter("dienThoai");
        String email = request.getParameter("email");
        String dongYNhanMail = request.getParameter("dongYNhanMail");
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

        request.setAttribute("baoLoi", baoLoi);


        if (baoLoi.length() > 0) {
            url = "/dangky.jsp";
        } else {
            Object obj = request.getSession().getAttribute("khachHang");
            KhachHang khachHang = null;
            if (obj != null)
                khachHang = (KhachHang) obj;
            if (khachHang != null) {
                String maKhachHang = khachHang.getMaKhachHang();
                KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
                khachHangDAO.updateInfor(kh);
                //tạo session mới
                KhachHang khm = khachHangDAO.selectById(kh);
                request.getSession().setAttribute("khachHang", khm);
                url = "/thanhcong1.jsp";
            }

        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}