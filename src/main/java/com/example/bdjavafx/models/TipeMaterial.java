package com.example.bdjavafx.models;

public class TipeMaterial {
   private int idTipe;
   private String namaTipe;
   private String recycleType;

   public TipeMaterial(int idTipe, String namaTipe, String recycleType) {
      this.idTipe = idTipe;
      this.namaTipe = namaTipe;
      this.recycleType = recycleType;
   }

   public int getIdTipe() {
      return idTipe;
   }

   public void setIdTipe(int idTipe) {
      this.idTipe = idTipe;
   }

   public String getNamaTipe() {
      return namaTipe;
   }

   public void setNamaTipe(String namaTipe) {
      this.namaTipe = namaTipe;
   }

   public String getRecycleType() {
      return recycleType;
   }

   public void setRecycleType(String recycleType) {
      this.recycleType = recycleType;
   }
}
