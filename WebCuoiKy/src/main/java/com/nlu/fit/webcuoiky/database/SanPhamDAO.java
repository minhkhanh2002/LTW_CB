package com.nlu.fit.webcuoiky.database;

import com.nlu.fit.webcuoiky.model.KhachHang;
import com.nlu.fit.webcuoiky.model.SanPham;
import com.nlu.fit.webcuoiky.model.TacGia;
import com.nlu.fit.webcuoiky.model.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO implements DAOInterface<SanPham> {

    public static void main(String[] args) {
        SanPhamDAO spd = new SanPhamDAO();
        List<SanPham> arrayList = spd.selectByName("cay");

        for (SanPham o : arrayList) {
            System.out.println(o);
        }

    }
    //test
    public List<SanPham> selectByName(String txtSearch) {
        SanPham sp = new SanPham();
        List<SanPham> ketQua = new ArrayList<>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM sanpham WHERE tensanpham LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+txtSearch+"%");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                String namxuatban = rs.getString("namxuatban");
                String gianhap = rs.getString("gianhap");
                String giagoc = rs.getString("giagoc");
                String giaban = rs.getString("giaban");
                String soluong =  rs.getString("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");
                String image = rs.getString("image");

                TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(matacgia, "", null, "")));
                TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(matheloai, "")));

                sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota, image);
                ketQua.add(sp);
                break;
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
    public List<SanPham> selectAll1() {
        List<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                String namxuatban = rs.getString("namxuatban");
                String gianhap = rs.getString("gianhap");
                String giagoc = rs.getString("giagoc");
                String giaban = rs.getString("giaban");
                String soluong =  rs.getString("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");
                String image = rs.getString("image");

                TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(matacgia, "", null, "")));
                TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(matheloai, "")));

                SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota, image);
                ketQua.add(sp);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                String namxuatban = rs.getString("namxuatban");
                String gianhap = rs.getString("gianhap");
                String giagoc = rs.getString("giagoc");
                String giaban = rs.getString("giaban");
                String soluong =  rs.getString("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");
                String image = rs.getString("image");

                TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(matacgia, "", null, "")));
                TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(matheloai, "")));

                SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota, image);
                ketQua.add(sp);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public SanPham selectById(SanPham t) {

        SanPham ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM sanpham WHERE masanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                String namxuatban = rs.getString("namxuatban");
                String gianhap = rs.getString("gianhap");
                String giagoc = rs.getString("giagoc");
                String giaban = rs.getString("giaban");
                String soluong =  rs.getString("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");
                String image = rs.getString("image");

                TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(matacgia, "", null, "")));
                TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(matheloai, "")));

                ketQua = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota,image);
                break;
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO sanpham (masanpham,tensanpham, matacgia, namxuatban,"
                    + " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota, image) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            st.setString(2, t.getTenSanPham());
            st.setString(3, t.getTacGia().getMaTacGia());
            st.setString(4, t.getNamXuatBan());
            st.setString(5, t.getGiaNhap());
            st.setString(6, t.getGiaGoc());
            st.setString(7, t.getGiaBan());
            st.setString(8, t.getSoLuong());
            st.setString(9, t.getTheLoai().getMaTheLoai());
            st.setString(10, t.getNgonNgu());
            st.setString(11, t.getMoTa());
            st.setString(12, t.getImage());

            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (SanPham SanPham : arr) {
            dem += this.insert(SanPham);
        }
        return dem;
    }

    @Override
    public int delete(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from sanpham " + " WHERE masanpham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (SanPham SanPham : arr) {
            dem += this.delete(SanPham);
        }
        return dem;
    }

    @Override
    public int update(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE sanpham " + " SET " + "tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
                    + "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?, image=?" + " WHERE masanpham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenSanPham());
            st.setString(2, t.getTacGia().getMaTacGia());
            st.setString(3, t.getNamXuatBan());
            st.setString(4, t.getGiaNhap());
            st.setString(5, t.getGiaGoc());
            st.setString(6, t.getGiaBan());
            st.setString(7, t.getSoLuong());
            st.setString(8, t.getTheLoai().getMaTheLoai());
            st.setString(9, t.getNgonNgu());
            st.setString(10, t.getMoTa());
            st.setString(11, t.getMaSanPham());
            st.setString(12, t.getImage());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }


}
