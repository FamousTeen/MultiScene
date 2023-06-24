package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.models.Mesin;
import com.example.bdjavafx.models.TipeMesin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipeMesinRepository {

    public List<TipeMesin> getAll() throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.createStatement();
        var resultSet = stmt.executeQuery("SELECT * FROM tipe_mesin");

        List<TipeMesin> tipeMesinList = new ArrayList<>();
        while (resultSet.next()) {
            int idTipe = resultSet.getInt("id_tipe");
            String fungsiMesin = resultSet.getString("kapasitas_mesin");
            String cara_kerja = resultSet.getString("cara_kerja");


            tipeMesinList.add(new TipeMesin(idTipe, fungsiMesin, cara_kerja));
        }
        resultSet.close();
        stmt.close();

        return tipeMesinList;
    }

    public void createTipeMesin(TipeMesin tipeMesin) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("INSERT INTO tipe_mesin VALUES (DEFAULT, ?, ?)" );
        stmt.setString(2, tipeMesin.getFungsi_mesin());
        stmt.setString(3, tipeMesin.getCara_kerja());
        stmt.execute();
    }
    public void updateTipeMesin(TipeMesin tipeMesin) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("UPDATE tipeMesin\n" +
                "SET fungsi_mesin = ?, cara_kerja = ?\n" +
                "WHERE id_tipe = ?;" );
        stmt.setString(1, tipeMesin.getFungsi_mesin());
        stmt.setString(2, tipeMesin.getCara_kerja());
        stmt.execute();
    }
    public void deleteProduksi(int idTipeMesin) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("DELETE FROM tipe_mesin\n" +
                "WHERE id_mesin = ?");
        stmt.setInt(1,idTipeMesin);
        stmt.execute();
    }

}

