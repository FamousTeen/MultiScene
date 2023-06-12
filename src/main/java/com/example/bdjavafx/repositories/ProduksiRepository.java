package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.models.Mesin;
import com.example.bdjavafx.models.Produksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduksiRepository {

   public List<Produksi> getAll() throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.createStatement();
      var resultSet = stmt.executeQuery("SELECT * FROM produksi");

      List<Produksi> produksiList = new ArrayList<>();
      while (resultSet.next()) {
         int idProduksi = resultSet.getInt("id_produksi");
         int biayaProduksi = resultSet.getInt("biaya_produksi");
         int jumlahEmployee = resultSet.getInt("jumlah_employee");
         String alamatWH = resultSet.getString("alamat_wh");
         int noTelp = resultSet.getInt("no_telp");
         int kapasitasRuang = resultSet.getInt("kapasitas_ruang");

         produksiList.add(new Produksi(idProduksi, biayaProduksi, jumlahEmployee, alamatWH, noTelp, kapasitasRuang));
      }
      resultSet.close();
      stmt.close();

      return produksiList;
   }

   public void createProduksi(Produksi produksi) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("INSERT INTO produksi VALUES (DEFAULT, ?, ?, ?, ?, ?)" );
      stmt.setInt(1, produksi.getBiayaProduksi());
      stmt.setInt(2, produksi.getJumlahEmployee());
      stmt.setString(3, produksi.getAlamatWH());
      stmt.setInt(4, produksi.getNoTelp());
      stmt.setInt(5, produksi.getKapasitasRuang());
      stmt.execute();
   }

}

