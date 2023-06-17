package com.example.bdjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class `Singleton` yang akan menghandle koneksi ke database.
 * Hanya akan ada 1 instance dalam lifetime aplikasi.
 * Untuk ambil koneksi bisa tinggal panggil fungsi `DBConnection.get()`.
 */
public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/projek_bd";
    private static final String user = "root";
    private static final String password = "";
    private static Connection connection;

    public static Connection get() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
