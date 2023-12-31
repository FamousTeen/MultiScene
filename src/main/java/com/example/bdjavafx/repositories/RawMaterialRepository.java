package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.models.RawMaterial;
import com.example.bdjavafx.models.TipeMaterial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RawMaterialRepository {

    public List<RawMaterial> getAll() throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.createStatement();
        var resultSet = stmt.executeQuery("SELECT * FROM raw_material");

        List<RawMaterial> rawMaterialList = new ArrayList<>();
        while (resultSet.next()) {
            int idMaterial = resultSet.getInt("id_material");
            int massaMaterial = resultSet.getInt("massa_material");
            int jumlahMaterial = resultSet.getInt("jumlah_material");
            int idTipe = resultSet.getInt("id_tipe");
            int idProduksi = resultSet.getInt("id_produksi");

            rawMaterialList.add(new RawMaterial(idMaterial, massaMaterial, jumlahMaterial, idTipe, idProduksi));
        }
        resultSet.close();
        stmt.close();

        return rawMaterialList;
    }

    public void createRawMaterial(RawMaterial rawMaterial) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("INSERT INTO raw_material VALUES (DEFAULT, ?, ?, ?, ?)" );
        stmt.setInt(1, rawMaterial.getMassaMaterial());
        stmt.setInt(2, rawMaterial.getJumlahMaterial());
        stmt.setInt(3, rawMaterial.getIdTipe());
        stmt.setInt(4, rawMaterial.getIdProduksi());
        stmt.execute();
    }
    public void updateRawMaterial(RawMaterial rawMaterial) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("UPDATE rawMaterial\n" +
                "SET massa_material = ?, jumlah_material = ? , id_tipe = ? , id_produksi = ?\n" +
                "WHERE id_material = ?;" );
        stmt.setInt(1, rawMaterial.getMassaMaterial());
        stmt.setInt(2, rawMaterial.getJumlahMaterial());
        stmt.setInt(3 , rawMaterial.getIdTipe());
        stmt.setInt(4, rawMaterial.getIdProduksi());
        stmt.execute();
    }
    public void deleteRawMaterial(int idRawMaterial) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("DELETE FROM raw_material\n" +
                "WHERE id_material = ?");
        stmt.setInt(1,idRawMaterial);
        stmt.execute();
    }

}
