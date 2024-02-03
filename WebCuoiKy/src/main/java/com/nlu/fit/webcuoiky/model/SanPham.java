package com.nlu.fit.webcuoiky.model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private TacGia tacGia;
    private String namXuatBan;
    private String giaNhap;
    private String giaGoc;
    private String giaBan;
    private String soLuong;
    private TheLoai theLoai;;
    private String ngonNgu;
    private String moTa;
    private String image;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, TacGia tacGia, String namXuatBan, String giaNhap, String giaGoc, String giaBan, String soLuong, TheLoai theLoai, String ngonNgu, String moTa, String image) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.giaNhap = giaNhap;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
        this.image = image;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(String giaGoc) {
        this.giaGoc = giaGoc;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", tacGia=" + tacGia +
                ", namXuatBan='" + namXuatBan + '\'' +
                ", giaNhap='" + giaNhap + '\'' +
                ", giaGoc='" + giaGoc + '\'' +
                ", giaBan='" + giaBan + '\'' +
                ", soLuong='" + soLuong + '\'' +
                ", theLoai=" + theLoai +
                ", ngonNgu='" + ngonNgu + '\'' +
                ", moTa='" + moTa + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public SanPham(String tenSanPham, String namXuatBan, String giaNhap, String giaGoc, String giaBan, String soLuong, TheLoai theLoai, String ngonNgu, String moTa, String image) {
        this.tenSanPham = tenSanPham;
        this.namXuatBan = namXuatBan;
        this.giaNhap = giaNhap;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
        this.image = image;
    }
}
