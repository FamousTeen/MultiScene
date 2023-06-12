package com.example.bdjavafx.repositories;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.models.Mesin;
import com.example.bdjavafx.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public List<Product> getAll() throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.createStatement();
        var resultSet = stmt.executeQuery("SELECT * FROM product");

        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            int idProduct = resultSet.getInt("id_mesin");
            String tglBuat = resultSet.getString("tgl_buat");
            int hargaProduk = resultSet.getInt("harga_produk");
            int massaProduk = resultSet.getInt("massa_produk");
            int idProduksi = resultSet.getInt("id_produksi");

            productList.add(new Product(idProduct, tglBuat, hargaProduk, massaProduk, idProduksi));
        }
        resultSet.close();
        stmt.close();

        return productList;
    }

    public void createProduct(Product product) throws SQLException {
        var conn = DBConnection.get();
        var stmt = conn.prepareStatement("INSERT INTO product VALUES (DEFAULT, ?, ?, ?, ?)" );
        stmt.setString(1, product.getTglBuat());
        stmt.setInt(2, product.getHargaProduk());
        stmt.setInt(3, product.getMassaProduk());
        stmt.setInt(4, product.getIdProduksi());
        stmt.execute();
    }

}
