package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Produksi;
import com.example.bdjavafx.models.TipeMaterial;
import com.example.bdjavafx.models.TipeMesin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipeMaterialRepository {

   public List<TipeMaterial> getAll() throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.createStatement();
      var resultSet = stmt.executeQuery("SELECT * FROM tipe_material");

      List<TipeMaterial> tipeMaterialList = new ArrayList<>();
      while (resultSet.next()) {
         int idTipe = resultSet.getInt("id_produksi");
         String namaTipe = resultSet.getString("nama_tipe");
         String recycleType = resultSet.getString("recycle_type");

         tipeMaterialList.add(new TipeMaterial(idTipe, namaTipe, recycleType));
      }
      resultSet.close();
      stmt.close();

      return tipeMaterialList;
   }

   public void createTipeMaterial(TipeMaterial tipeMaterial) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("INSERT INTO tipe_material VALUES (DEFAULT, ?, ?)" );
      stmt.setString(1, tipeMaterial.getNamaTipe());
      stmt.setString(2, tipeMaterial.getRecycleType());
      stmt.execute();
   }
   public void updateTipeMaterial(TipeMaterial tipeMaterial) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("UPDATE tipeMaterial\n" +
              "SET nama_tipe = ?, recycle_type = ?\n" +
              "WHERE id_tipe = ?;" );
      stmt.setString(1, tipeMaterial.getNamaTipe());
      stmt.setString(2, tipeMaterial.getRecycleType());
      stmt.execute();
   }

}