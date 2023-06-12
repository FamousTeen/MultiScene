package com.example.bdjavafx.models;

public class Employee {
    private int idEmployee;
    private String namaEmployee;
    private String alamat;
    private String tglLahir;

    private int idPeran;
    private int idProduksi;

    public Employee(int idEmployee, String namaEmployee, String alamat, String tglLahir, int idPeran, int idProduksi) {
        this.idEmployee = idEmployee;
        this.namaEmployee = namaEmployee;
        this.alamat = alamat;
        this.tglLahir = tglLahir;
        this.idPeran = idPeran;
        this.idProduksi = idProduksi;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNamaEmployee() {
        return namaEmployee;
    }

    public void setNamaEmployee(String namaEmployee) {
        this.namaEmployee = namaEmployee;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public int getIdProduksi() {
        return idProduksi;
    }

    public void setIdProduksi(int idProduksi) {
        this.idProduksi = idProduksi;
    }

    public int getIdPeran() {
        return idPeran;
    }

    public void setIdPeran(int idPeran) {
        this.idPeran = idPeran;
    }
}
