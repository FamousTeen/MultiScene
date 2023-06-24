package com.example.bdjavafx.controllers;

import com.example.bdjavafx.HelloApplication;
import com.example.bdjavafx.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateSceneController extends ManagementSceneController implements Initializable {
    @FXML
    private ComboBox<String> PILIH_TABLE;

//   TEXT COLUMN
    @FXML
    private Label TEXT_1;
    @FXML
    private Label TEXT_2;
    @FXML
    private Label TEXT_3;
    @FXML
    private Label TEXT_4;
    @FXML
    private Label TEXT_5;
    @FXML
    private Label TEXT_6;

//  FIELD (DATA KOLOM)
    @FXML
    private TextField FIELD_1;
    @FXML
    private TextField FIELD_2;
    @FXML
    private TextField FIELD_3;
    @FXML
    private TextField FIELD_4;
    @FXML
    private TextField FIELD_5;
    @FXML
    private TextField FIELD_6;

//  TEXT UNTUK STATUS PERUBAHAN
    @FXML
    private Label STATUS_TEXT;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList <String> listTable = FXCollections.observableArrayList
                ("Employee", "Mesin", "Peran Employee", "Product", "Produksi", "Raw Material", "Tipe Material"
                        , "Tipe Mesin");


        PILIH_TABLE.setItems(listTable);
        disableAll(); // membuat semua text dan field invisible

        PILIH_TABLE.setOnAction(event -> {
            String selectedOption = PILIH_TABLE.getSelectionModel().getSelectedItem();

            // Execute different code based on the selected option
            if (selectedOption.equals("Employee")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Employee", "Nama Employee", "Alamat",
                        "Tanggal Lahir", "ID Peran", "ID Produksi", true, true,
                        true, true, true, true);
            } else if (selectedOption.equals("Mesin")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Mesin", "Kapasitas Mesin", "Harga Mesin",
                        "ID Tipe", "ID Produksi", null, true, true,
                        true, true, true, false);
            } else if (selectedOption.equals("Peran Employee")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Peran", "Nama Peran", "Jabatan", null, null,
                        null, true, true, true, false, false, false);
            } else if (selectedOption.equals("Product")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Produk", "Tanggal Buat", "Harga Produk",
                        "Massa Produk", "ID Produksi", null, true, true,
                        true, true, true, false);
            } else if (selectedOption.equals("Produksi")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Produksi", "Biaya Produksi", "Jumlah Employee",
                        "Alamat Warehouse", "No Telepon", "Kapasitas Ruang", true, true,
                        true, true, true, true);
            } else if (selectedOption.equals("Raw Material")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Material", "Massa Material",
                        "Jumlah Material", "ID Tipe", "ID Produksi", null,  true, true,
                        true, true, true, false);
            } else if (selectedOption.equals("Tipe Material")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Tipe", "Nama Tipe", "Recycle Type", null, null,
                        null, true, true, true, false, false, false);
            } else if (selectedOption.equals("Tipe Mesin")) {
                STATUS_TEXT.setVisible(false);
                setFieldAndText("ID Tipe", "Fungsi Mesin", "Cara Kerja", null, null,
                        null, true, true, true, false, false, false);
            }
        });
    }

    @FXML
    public void clear() {
        FIELD_1.setText(null);
        FIELD_2.setText(null);
        FIELD_3.setText(null);
        FIELD_4.setText(null);
        FIELD_5.setText(null);
        FIELD_6.setText(null);
    }

    @FXML
    public void submit () {
        String selectedOption = PILIH_TABLE.getSelectionModel().getSelectedItem();
        if (selectedOption.equals("Employee")) {
            int id = Integer.parseInt(FIELD_1.getText());
            String nama = FIELD_2.getText();
            String address = FIELD_3.getText();
            String tglLahir = FIELD_4.getText();
            int idPeran = Integer.parseInt(FIELD_5.getText());
            int idProduksi = Integer.parseInt(FIELD_6.getText());
            try {
                rep_emp.createEmployee(new Employee(id, nama, address, tglLahir, idPeran, idProduksi));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to EMPLOYEE");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Mesin")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            int kapasitas = Integer.parseInt(FIELD_2.getText());
            int harga = Integer.parseInt(FIELD_3.getText());
            int idTipe = Integer.parseInt(FIELD_4.getText());
            int idProduksi = Integer.parseInt(FIELD_5.getText());
            try {
                rep_mesin.createMesin(new Mesin(id, kapasitas, harga, idTipe, idProduksi));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to MESIN");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Peran Employee")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            String nama = FIELD_2.getText();
            String jabatan = FIELD_3.getText();
            try {
                rep_peran.createPeran(new PeranEmployee(id, nama, jabatan));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to PERAN_EMPLOYEE");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Product")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            String tglBuat = FIELD_2.getText();
            int harga = Integer.parseInt(FIELD_3.getText());
            int massa = Integer.parseInt(FIELD_4.getText());
            int idProduksi = Integer.parseInt(FIELD_5.getText());
            try {
                rep_product.createProduct(new Product(id, tglBuat, harga, massa, idProduksi));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to PRODUCT");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Produksi")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            int biaya = Integer.parseInt(FIELD_2.getText());
            int jumlahEmp = Integer.parseInt(FIELD_3.getText());
            String alamatWH = FIELD_4.getText();
            int noTelp = Integer.parseInt(FIELD_5.getText());
            int kapasitas = Integer.parseInt(FIELD_6.getText());
            try {
                rep_production.createProduksi(new Produksi(id, biaya, jumlahEmp, alamatWH, noTelp, kapasitas));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to PRODUKSI");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Raw Material")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            int massa = Integer.parseInt(FIELD_2.getText());
            int jumlah = Integer.parseInt(FIELD_3.getText());
            int idTipe = Integer.parseInt(FIELD_4.getText());
            int idProduksi = Integer.parseInt(FIELD_5.getText());
            try {
                rep_raw.createRawMaterial(new RawMaterial(id, massa, jumlah, idTipe, idProduksi));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to RAW_MATERIAL");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Tipe Material")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            String nama = FIELD_2.getText();
            String recycleType = FIELD_3.getText();
            try {
                repTipeMaterial.createTipeMaterial(new TipeMaterial(id, nama, recycleType));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to TIPE_MATERIAL");
            STATUS_TEXT.setVisible(true);
        } else if (selectedOption.equals("Tipe Mesin")) {
            STATUS_TEXT.setVisible(false);
            int id = Integer.parseInt(FIELD_1.getText());
            String fungsi = FIELD_2.getText();
            String caraKerja = FIELD_3.getText();
            try {
                rep_tipeMesin.createTipeMesin(new TipeMesin(id, fungsi, caraKerja));
                refreshTable();
            } catch (SQLException s) {
                System.out.println("Error " + s);
            }
            STATUS_TEXT.setText("1 row is added to TIPE_MESIN");
            STATUS_TEXT.setVisible(true);
        }
    }
    
    public void disableAll () { // membuat semua field dan text invisible
        TEXT_1.setVisible(false);
        TEXT_2.setVisible(false);
        TEXT_3.setVisible(false);
        TEXT_4.setVisible(false);
        TEXT_5.setVisible(false);
        TEXT_6.setVisible(false);
        FIELD_1.setVisible(false);
        FIELD_2.setVisible(false);
        FIELD_3.setVisible(false);
        FIELD_4.setVisible(false);
        FIELD_5.setVisible(false);
        FIELD_6.setVisible(false);
        STATUS_TEXT.setVisible(false);
    }


//  untuk mengsetting semua field and text
    public void setFieldAndText(String column1, String column2, String column3,
                                String column4, String column5, String column6,
                                boolean isVisible1, boolean isVisible2, boolean isVisible3,
                                boolean isVisible4, boolean isVisible5, boolean isVisible6) {
        TEXT_1.setText(column1);
        TEXT_2.setText(column2);
        TEXT_3.setText(column3);
        TEXT_4.setText(column4);
        TEXT_5.setText(column5);
        TEXT_6.setText(column6);
        TEXT_1.setVisible(isVisible1);
        TEXT_2.setVisible(isVisible2);
        TEXT_3.setVisible(isVisible3);
        TEXT_4.setVisible(isVisible4);
        TEXT_5.setVisible(isVisible5);
        TEXT_6.setVisible(isVisible6);
        FIELD_1.setVisible(isVisible1);
        FIELD_2.setVisible(isVisible2);
        FIELD_3.setVisible(isVisible3);
        FIELD_4.setVisible(isVisible4);
        FIELD_5.setVisible(isVisible5);
        FIELD_6.setVisible(isVisible6);
    }

    @FXML
    public void toPembelian() throws IOException {
        HelloApplication.getScene("main").show();
    }

}
