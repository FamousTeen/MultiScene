package com.example.bdjavafx.models;

public class Mesin {
   private int idMesin;
   private int kapasitasMesin;
   private int hargaMesin;
   private int idTipe;
   private int idProduksi;

   public Mesin(int idMesin, int kapasitasMesin, int hargaMesin, int idTipe, int idProduksi) {
      this.idMesin = idMesin;
      this.kapasitasMesin = kapasitasMesin;
      this.hargaMesin = hargaMesin;
      this.idTipe = idTipe;
      this.idProduksi = idProduksi;
   }

   public int getIdMesin() {
      return idMesin;
   }

   public void setIdMesin(int idMesin) {
      this.idMesin = idMesin;
   }

   public int getKapasitasMesin() {
      return kapasitasMesin;
   }

   public void setKapasitasMesin(int kapasitasMesin) {
      this.kapasitasMesin = kapasitasMesin;
   }

   public int getHargaMesin() {
      return hargaMesin;
   }

   public void setHargaMesin(int hargaMesin) {
      this.hargaMesin = hargaMesin;
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
