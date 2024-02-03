package com.nlu.fit.webcuoiky.model;

public class ChiTietGioHang {

    private SanPham sanPham;
    private Integer soLuong;
    private KhachHang khachHang;

    public ChiTietGioHang() {
    }

    public ChiTietGioHang(SanPham sanPham, KhachHang khachHang) {
        this.sanPham = sanPham;
        this.khachHang = khachHang;
    }

    public ChiTietGioHang(SanPham sanPham, Integer soLuong, KhachHang khachHang) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.khachHang = khachHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;

    }

    @Override
    public String toString() {
        return "ChiTietGioHang{" +
                "sanPham=" + sanPham +
                ", soLuong=" + soLuong +
                ", khachHang=" + khachHang +
                '}';
    }

    public void incrementQuantity() {
        this.soLuong++;
    }

    public void incrementQuantityWithQuantity(int quantity) {
        this.soLuong+= soLuong;
    }
}
