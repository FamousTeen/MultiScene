package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.PeranEmployee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeranEmployeeRepository {
   public List<PeranEmployee> getAll() throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.createStatement();
      var resultSet = stmt.executeQuery("SELECT * FROM peran_employee");

      List<PeranEmployee> peranList = new ArrayList<>();
      while (resultSet.next()) {
         int idPeran = resultSet.getInt("id_peran");
         String namaPeran = resultSet.getString("nama_peran");
         String jabatan = resultSet.getString("jabatan");

         peranList.add(new PeranEmployee(idPeran, namaPeran, jabatan));
      }
      resultSet.close();
      stmt.close();

      return peranList;
   }

   public void createPeran(PeranEmployee peran) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("INSERT INTO peran_employee VALUES (DEFAULT, ?, ?)" );
      stmt.setString(1, peran.getNamaPeran());
      stmt.setString(2, peran.getJabatan());
      stmt.execute();
   }
}
