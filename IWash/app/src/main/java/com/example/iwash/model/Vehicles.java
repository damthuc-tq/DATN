package com.example.iwash.model;

public class Vehicles {
    String loaiXe, mauXe, hangXe, bienSo;

    public Vehicles(String loaiXe, String mauXe, String hangXe, String bienSo) {
        this.loaiXe = loaiXe;
        this.mauXe = mauXe;
        this.hangXe = hangXe;
        this.bienSo = bienSo;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
}
