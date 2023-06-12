package com.example.bdjavafx.models;

public class Product {
   private int idProduct;
   private String tglBuat;
   private int hargaProduk;
   private int massaProduk;
   private int idProduksi;

   public Product(int idProduct, String tglBuat, int hargaProduk, int massaProduk, int idProduksi) {
      this.idProduct = idProduct;
      this.tglBuat = tglBuat;
      this.hargaProduk = hargaProduk;
      this.massaProduk = massaProduk;
      this.idProduksi = idProduksi;
   }

   public int getIdProduct() {
      return idProduct;
   }

   public void setIdProduct(int idProduct) {
      this.idProduct = idProduct;
   }

   public String getTglBuat() {
      return tglBuat;
   }

   public void setTglBuat(String tglBuat) {
      this.tglBuat = tglBuat;
   }

   public int getHargaProduk() {
      return hargaProduk;
   }

   public void setHargaProduk(int hargaProduk) {
      this.hargaProduk = hargaProduk;
   }

   public int getMassaProduk() {
      return massaProduk;
   }

   public void setMassaProduk(int massaProduk) {
      this.massaProduk = massaProduk;
   }

   public int getIdProduksi() {
      return idProduksi;
   }

   public void setIdProduksi(int idProduksi) {
      this.idProduksi = idProduksi;
   }
}
