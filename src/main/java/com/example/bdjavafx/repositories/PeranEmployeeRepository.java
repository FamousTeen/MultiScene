package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Mesin;
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

   public void deletePeran() throws SQLException {
      var conn = DBConnection.get();
      var stmt1 = conn.prepareStatement("TRUNCATE TABLE peran_employee");
      stmt1.execute();
      var stmt = conn.prepareStatement("DELETE FROM peran_employee");
      stmt.execute();
   }

   public void updatePeran(PeranEmployee peran) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("UPDATE peran_employee\n" +
              "SET nama_peran = ?, jabatan = ?\n" +
              "WHERE id_peran = ?;" );
      stmt.setString(1, peran.getNamaPeran());
      stmt.setString(2, peran.getJabatan());
      stmt.setInt(3, peran.getIdPeran());
      stmt.execute();
   }
   public void deletePeranEmployee(int idPeran) throws SQLException {
      var conn = DBConnection.get();
      var stmt = conn.prepareStatement("DELETE FROM peran_employee\n" +
              "WHERE id_peran = ?");
      stmt.setInt(1,idPeran);
      stmt.execute();
   }
}
