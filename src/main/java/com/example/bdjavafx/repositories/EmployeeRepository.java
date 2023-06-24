package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> getAll() throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.createStatement();
        var resultSet = stmt.executeQuery("SELECT * FROM employee");

        List<Employee> mesinList = new ArrayList<>();
        while (resultSet.next()) {
            int idEmployee = resultSet.getInt("id_employee");
            String namaEmployee = resultSet.getString("nama_employee");
            String alamat = resultSet.getString("alamat");
            String tglLahir = resultSet.getString("tgl_lahir");
            int idPeran = resultSet.getInt("id_peran");
            int idProduksi = resultSet.getInt("id_produksi");

            mesinList.add(new Employee(idEmployee, namaEmployee, alamat, tglLahir, idPeran, idProduksi));
        }
        resultSet.close();
        stmt.close();

        return mesinList;
    }

    public void createEmployee(Employee employee) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("INSERT INTO employee " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?)" );
        stmt.setString(1, employee.getNamaEmployee());
        stmt.setString(2, employee.getAlamat());
        stmt.setString(3, employee.getTglLahir());
        stmt.setInt(4, employee.getIdPeran());
        stmt.setInt(5, employee.getIdProduksi());
        stmt.execute();
    }

    public void deleteEmployee() throws SQLException {
        var conn = DBConnection.get();
        var stmt1 = conn.prepareStatement("TRUNCATE TABLE employee");
        stmt1.execute();
    }

    public void updateEmployee(Employee employee) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("UPDATE employee\n" +
                "SET nama_employee = ?, alamat = ?, tgl_lahir = ?," +
                "id_peran = ?, id_produksi = ?\n" +
                "WHERE kondisi;" );
        stmt.setString(1, employee.getNamaEmployee());
        stmt.setString(2, employee.getAlamat());
        stmt.setString(3, employee.getTglLahir());
        stmt.setInt(4, employee.getIdPeran());
        stmt.setInt(5, employee.getIdProduksi());
        stmt.execute();
    }



}
