package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.models.Mesin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesinRepository {

   public List<Mesin> getAll() throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.createStatement();
      var resultSet = stmt.executeQuery("SELECT * FROM mesin");

      List<Mesin> mesinList = new ArrayList<>();
      while (resultSet.next()) {
         int idMesin = resultSet.getInt("id_mesin");
         int kapasitasMesin = resultSet.getInt("kapasitas_mesin");
         int hargaMesin = resultSet.getInt("harga_mesin");
         int idTipe = resultSet.getInt("id_tipe");
         int idProduksi = resultSet.getInt("id_produksi");

         mesinList.add(new Mesin(idMesin, kapasitasMesin, hargaMesin, idTipe, idProduksi));
      }
      resultSet.close();
      stmt.close();

      return mesinList;
   }

   public void createMesin(Mesin mesin) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("INSERT INTO mesin VALUES (DEFAULT, ?, ?, ?, ?)" );
      stmt.setInt(1, mesin.getKapasitasMesin());
      stmt.setInt(2, mesin.getHargaMesin());
      stmt.setInt(3, mesin.getIdTipe());
      stmt.setInt(4, mesin.getIdProduksi());
      stmt.execute();
   }

}

