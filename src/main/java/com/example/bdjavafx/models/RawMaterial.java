package com.example.bdjavafx.models;

public class RawMaterial {
   private int idMaterial;
   private int massaMaterial;
   private int jumlahMaterial;
   private int idTipe;
   private int idProduksi;

   public RawMaterial(int idMaterial, int massaMaterial, int jumlahMaterial, int idTipe, int idProduksi) {
      this.idMaterial = idMaterial;
      this.massaMaterial = massaMaterial;
      this.jumlahMaterial = jumlahMaterial;
      this.idTipe = idTipe;
      this.idProduksi = idProduksi;
   }

   public int getIdMaterial() {
      return idMaterial;
   }

   public void setIdMaterial(int idMaterial) {
      this.idMaterial = idMaterial;
   }


   public int getMassaMaterial() {
      return massaMaterial;
   }

   public void setMassaMaterial(int massaMaterial) {
      this.massaMaterial = massaMaterial;
   }

   public int getJumlahMaterial() {
      return jumlahMaterial;
   }

   public void setJumlahMaterial(int jumlahMaterial) {
      this.jumlahMaterial = jumlahMaterial;
   }

   public int getIdTipe() {
      return idTipe;
   }

   public void setIdTipe(int idTipe) {
      this.idTipe = idTipe;
   }

   public int getIdProduksi() {
      return idProduksi;
   }

   public void setIdProduksi(int idProduksi) {
      this.idProduksi = idProduksi;
   }
}
