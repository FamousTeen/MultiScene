package com.example.bdjavafx.models;

public class PeranEmployee {
   private int idPeran;
   private String namaPeran;
   private String jabatan;

   public PeranEmployee(int idPeran, String namaPeran, String jabatan) {
      this.idPeran = idPeran;
      this.namaPeran = namaPeran;
      this.jabatan = jabatan;
   }

   public int getIdPeran() {
      return idPeran;
   }

   public void setIdPeran(int idPeran) {
      this.idPeran = idPeran;
   }

   public String getNamaPeran() {
      return namaPeran;
   }

   public void setNamaPeran(String namaPeran) {
      this.namaPeran = namaPeran;
   }

   public String getJabatan() {
      return jabatan;
   }

   public void setJabatan(String jabatan) {
      this.jabatan = jabatan;
   }
}
