package com.example.bdjavafx.models;

public class Produksi {
   private int idProduksi;
   private int biayaProduksi;
   private int jumlahEmployee;
   private String alamatWH;
   private int noTelp;
   private int kapasitasRuang;

   public Produksi(int idProduksi, int biayaProduksi, int jumlahEmployee, String alamatWH, int noTelp, int kapasitasRuang) {
      this.idProduksi = idProduksi;
      this.biayaProduksi = biayaProduksi;
      this.jumlahEmployee = jumlahEmployee;
      this.alamatWH = alamatWH;
      this.noTelp = noTelp;
      this.kapasitasRuang = kapasitasRuang;
   }

   public int getIdProduksi() {
      return idProduksi;
   }

   public void setIdProduksi(int idProduksi) {
      this.idProduksi = idProduksi;
   }

   public int getBiayaProduksi() {
      return biayaProduksi;
   }

   public void setBiayaProduksi(int biayaProduksi) {
      this.biayaProduksi = biayaProduksi;
   }

   public int getJumlahEmployee() {
      return jumlahEmployee;
   }

   public void setJumlahEmployee(int jumlahEmployee) {
      this.jumlahEmployee = jumlahEmployee;
   }

   public String getAlamatWH() {
      return alamatWH;
   }

   public void setAlamatWH(String alamatWH) {
      this.alamatWH = alamatWH;
   }

   public int getNoTelp() {
      return noTelp;
   }

   public void setNoTelp(int noTelp) {
      this.noTelp = noTelp;
   }

   public int getKapasitasRuang() {
      return kapasitasRuang;
   }

   public void setKapasitasRuang(int kapasitasRuang) {
      this.kapasitasRuang = kapasitasRuang;
   }
}
