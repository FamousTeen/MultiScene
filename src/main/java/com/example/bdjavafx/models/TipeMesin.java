package com.example.bdjavafx.models;

public class TipeMesin {

    private int id_tipe;
    private String fungsi_mesin;

    private String cara_kerja;

    public TipeMesin(int id_tipe, String fungsi_mesin, String cara_kerja) {
        this.id_tipe = id_tipe;
        this.fungsi_mesin = fungsi_mesin;
        this.cara_kerja = cara_kerja;
    }

    public int getId_tipe() {
        return id_tipe;
    }

    public void setId_tipe(int id_tipe) {
        this.id_tipe = id_tipe;
    }

    public String getFungsi_mesin() {
        return fungsi_mesin;
    }

    public void setFungsi_mesin(String fungsi_mesin) {
        this.fungsi_mesin = fungsi_mesin;
    }

    public String getCara_kerja() {
        return cara_kerja;
    }

    public void setCara_kerja(String cara_kerja) {
        this.cara_kerja = cara_kerja;
    }
}
