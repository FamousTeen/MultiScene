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
         int hargaMesin = resultSet.getInt("alamat");
         String tglLahir = resultSet.getString("tgl_lahir");
         int idPeran = resultSet.getInt("id_peran");
         int idProduksi = resultSet.getInt("id_produksi");

         employeeList.add(new Employee(idEmployee, namaEmployee, alamat, tglLahir, idPeran, idProduksi));
      }
      resultSet.close();
      stmt.close();

      return employeeList;
   }

   public void createPembelian(Employee employee) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("INSERT INTO employee VALUES (DEFAULT, ?, ?, ?, ?, ?)" );
      stmt.setString(1, employee.getNamaEmployee());
      stmt.setString(2, employee.getAlamat());
      stmt.setString(3, employee.getTglLahir());
      stmt.setInt(4, employee.getIdPeran());
      stmt.setInt(5, employee.getIdProduksi());
      stmt.execute();
   }

}

