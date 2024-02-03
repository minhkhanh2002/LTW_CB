package com.nlu.fit.webcuoiky.Ulti;

public class Check {
	
	  //Hàm kiểm tra mật khẩu
    public static boolean kiemTraMatKhau(String matKhau) {
        // Ít nhất 6 ký tự
        if (matKhau.length() < 6) {
            return false;
        }

        // Ít nhất 1 số
        boolean coSo = false;
        for (char kyTu : matKhau.toCharArray()) {
            if (Character.isDigit(kyTu)) {
                coSo = true;
                break;
            }
        }

        // Ít nhất 1 chữ cái in hoa
        boolean coInHoa = false;
        for (char kyTu : matKhau.toCharArray()) {
            if (Character.isUpperCase(kyTu)) {
                coInHoa = true;
                break;
            }
        }

        // Kiểm tra và trả về kết quả cuối cùng
        return coSo && coInHoa;
    }

    public static void main(String[] args) {
        System.out.println(kiemTraMatKhau("Minhphuong2003"));
    }
}
