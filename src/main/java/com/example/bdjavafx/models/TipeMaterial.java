package com.example.bdjavafx.models;

public class TipeMaterial {
   private int idTipe;
   private String fungsiMesin;
   private String recycleType;

   public TipeMaterial(int idTipe, String fungsiMesin, String recycleType) {
      this.idTipe = idTipe;
      this.fungsiMesin = fungsiMesin;
      this.recycleType = recycleType;
   }

   public int getIdTipe() {
      return idTipe;
   }

   public void setIdTipe(int idTipe) {
      this.idTipe = idTipe;
   }

   public String getFungsiMesin() {
      return fungsiMesin;
   }

   public void setFungsiMesin(String fungsiMesin) {
      this.fungsiMesin = fungsiMesin;
   }

   public String getRecycleType() {
      return recycleType;
   }

   public void setRecycleType(String recycleType) {
      this.recycleType = recycleType;
   }
}
