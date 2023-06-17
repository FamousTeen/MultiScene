package com.example.bdjavafx.controllers;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.*;
import com.example.bdjavafx.repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagementSceneController implements Initializable {
    // Employee
    private EmployeeRepository rep_emp;
    private ObservableList<Employee> employeeList;

    // Peran_employee
    private PeranEmployeeRepository rep_peran;
    private ObservableList<PeranEmployee> peranList;

    // Produksi
    private ProduksiRepository rep_production;
    private ObservableList<Produksi> produksiList;

    // Mesin
    private MesinRepository rep_mesin;
    private ObservableList<Mesin> mesinList;

    // Tipe_mesin
    private TipeMesinRepository rep_tipeMesin;
    private ObservableList<TipeMesin> tipeMesinList;

    // Product
    private ProductRepository rep_product;
    private ObservableList<Product> productList;

    // Raw Material
    private RawMaterialRepository rep_raw;
    private ObservableList<RawMaterial> rawList;

    // Tipe Material
    private TipeMaterialRepository repTipeMaterial;
    private ObservableList<TipeMaterial> tipeMaterialList;


    @FXML
    public TextField textField;
    @FXML
    public TextField textField1;
    @FXML
    public TextField textField11;

    @FXML
    public TableView<Employee> TABLE_EMP;
    @FXML
    public TableView<PeranEmployee> TABLE_PERAN;
    @FXML
    public TableView<Produksi> TABLE_PRODUKSI;
    @FXML
    public TableView<Mesin> TABLE_MESIN;
    @FXML
    public TableView<TipeMesin> TABLE_TIPE_MESIN;
    @FXML
    public TableView<Product> TABLE_PRODUCT;
    @FXML
    public TableView<RawMaterial> TABLE_RAW;
    @FXML
    public TableView<TipeMaterial> TABLE_TIPE_MATERIAL;

    @FXML
    public Button SUBMIT_BUTTON;
    @FXML
    public Button SUBMIT_BUTTON1;
    @FXML
    public Button SUBMIT_BUTTON11;

    // BUAT TABLE EMPLOYEE
    @FXML
    public TableColumn<Employee, Integer> ID_EMP;
    @FXML
    public TableColumn<Employee, String> NAMA_EMP;
    @FXML
    public TableColumn<Employee, String> EMP_ADDRESS;
    @FXML
    public TableColumn<Employee, String> EMP_BIRTH;
    @FXML
    public TableColumn<Employee, Integer> PERAN_FK;
    @FXML
    public TableColumn<Employee, Integer> PRODUKSI_FK;

    // BUAT TABLE PERAN_EMPLOYEE
    @FXML
    public TableColumn<PeranEmployee, Integer> ID_PERAN;
    @FXML
    public TableColumn<PeranEmployee, String> NAMA_PERAN;
    @FXML
    public TableColumn<PeranEmployee, String> POST_EMP;

    // BUAT TABLE PRODUKSI
    @FXML
    public TableColumn<Produksi, Integer> ID_PRODUKSI;
    @FXML
    public TableColumn<Produksi, Integer> BIAYA_PROD;
    @FXML
    public TableColumn<Produksi, Integer> JUMLAH_EMP;
    @FXML
    public TableColumn<Produksi, String> WH_ADDRESS;
    @FXML
    public TableColumn<Produksi, Integer> TELP_PROD;
    @FXML
    public TableColumn<Produksi, Integer> PROD_CAPACITY;

    // BUAT TABLE MESIN
    @FXML
    public TableColumn<Mesin, Integer> ID_MESIN;
    @FXML
    public TableColumn<Mesin, Integer> MESIN_CAP;
    @FXML
    public TableColumn<Mesin, Integer> HARGA_MESIN;
    @FXML
    public TableColumn<Mesin, Integer> ID_TIPE_FK;
    @FXML
    public TableColumn<Mesin, Integer> ID_PRODUKSI2;

    // BUAT TABLE TIPE_MESIN
    @FXML
    public TableColumn<TipeMesin, Integer> ID_TIPE_PK;
    @FXML
    public TableColumn<TipeMesin, String> FUNGSI_MESIN;
    @FXML
    public TableColumn<TipeMesin, String> CARA_KERJA;

    // BUAT TABLE PRODUCT
    @FXML
    public TableColumn<Product, Integer> ID_PRODUCT;
    @FXML
    public TableColumn<Product, String> TANGGAL_BUAT;
    @FXML
    public TableColumn<Product, Integer> HARGA_PRODUK;
    @FXML
    public TableColumn<Product, Integer> MASSA_PRODUK;
    @FXML
    public TableColumn<Product, Integer> ID_PRODUKSI3;

    // BUAT TABLE RAW_MATERIAL
    @FXML
    public TableColumn<Product, Integer> ID_MATERIAL;
    @FXML
    public TableColumn<Product, String> TIPE_MATERIAL;
    @FXML
    public TableColumn<Product, Integer> MASSA_MATERIAL;
    @FXML
    public TableColumn<Product, Integer> JUMLAH_MATERIAL;
    @FXML
    public TableColumn<Product, Integer> ID_TIPE_FK2;
    @FXML
    public TableColumn<Product, Integer> ID_PRODUKSI4;

    // BUAT TABLE TIPE_MATERIAL
    @FXML
    public TableColumn<TipeMaterial, Integer> ID_TIPE_PK2;
    @FXML
    public TableColumn<TipeMaterial, String> NAMA_TIPE;
    @FXML
    public TableColumn<TipeMaterial, String> RECYCLE_TYPE;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            rep_emp = new EmployeeRepository();
            rep_peran = new PeranEmployeeRepository();
            rep_production = new ProduksiRepository();
            rep_mesin = new MesinRepository();
            rep_tipeMesin = new TipeMesinRepository();
            rep_product = new ProductRepository();
            rep_raw = new RawMaterialRepository();
            repTipeMaterial = new TipeMaterialRepository();

            // TABLE EMPLOYEE
            ID_EMP.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
            NAMA_EMP.setCellValueFactory(new PropertyValueFactory<>("namaEmployee"));
            EMP_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("alamat"));
            EMP_BIRTH.setCellValueFactory(new PropertyValueFactory<>("tglLahir"));
            PERAN_FK.setCellValueFactory(new PropertyValueFactory<>("idPeran"));
            PRODUKSI_FK.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));

            // TABLE PERAN
            ID_PERAN.setCellValueFactory(new PropertyValueFactory<>("idPeran"));
            NAMA_PERAN.setCellValueFactory(new PropertyValueFactory<>("namaPeran"));
            POST_EMP.setCellValueFactory(new PropertyValueFactory<>("jabatan"));

            // TABLE PRODUKSI
            ID_PRODUKSI.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));
            BIAYA_PROD.setCellValueFactory(new PropertyValueFactory<>("biayaProduksi"));
            JUMLAH_EMP.setCellValueFactory(new PropertyValueFactory<>("jumlahEmployee"));
            WH_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("alamatWH"));
            TELP_PROD.setCellValueFactory(new PropertyValueFactory<>("noTelp"));
            PROD_CAPACITY.setCellValueFactory(new PropertyValueFactory<>("kapasitasRuang"));

            // TABLE MESIN
            ID_MESIN.setCellValueFactory(new PropertyValueFactory<>("idMesin"));
            MESIN_CAP.setCellValueFactory(new PropertyValueFactory<>("kapasitasMesin"));
            HARGA_MESIN.setCellValueFactory(new PropertyValueFactory<>("hargaMesin"));
            ID_TIPE_FK.setCellValueFactory(new PropertyValueFactory<>("idTipe"));
            ID_PRODUKSI2.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));

            // TABLE TIPE_MESIN
            ID_TIPE_PK.setCellValueFactory(new PropertyValueFactory<>("id_tipe"));
            FUNGSI_MESIN.setCellValueFactory(new PropertyValueFactory<>("fungsi_mesin"));
            CARA_KERJA.setCellValueFactory(new PropertyValueFactory<>("cara_kerja"));

            // TABLE PRODUCT
            ID_PRODUCT.setCellValueFactory(new PropertyValueFactory<>("idProduct"));
            TANGGAL_BUAT.setCellValueFactory(new PropertyValueFactory<>("tglBuat"));
            HARGA_PRODUK.setCellValueFactory(new PropertyValueFactory<>("hargaProduk"));
            MASSA_PRODUK.setCellValueFactory(new PropertyValueFactory<>("massaProduk"));
            ID_PRODUKSI3.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));

            // TABLE RAW_MATERIAL
            ID_MATERIAL.setCellValueFactory(new PropertyValueFactory<>("idMaterial"));
            TIPE_MATERIAL.setCellValueFactory(new PropertyValueFactory<>("tipeMaterial"));
            MASSA_MATERIAL.setCellValueFactory(new PropertyValueFactory<>("massaMaterial"));
            JUMLAH_MATERIAL.setCellValueFactory(new PropertyValueFactory<>("jumlahMaterial"));
            ID_TIPE_FK2.setCellValueFactory(new PropertyValueFactory<>("idTipe"));
            ID_PRODUKSI4.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));

            // TABLE TIPE_MATERIAL
            ID_TIPE_PK2.setCellValueFactory(new PropertyValueFactory<>("idTipe"));
            NAMA_TIPE.setCellValueFactory(new PropertyValueFactory<>("namaTipe"));
            RECYCLE_TYPE.setCellValueFactory(new PropertyValueFactory<>("recycleType"));


            employeeList = FXCollections.observableArrayList();
            peranList = FXCollections.observableArrayList();
            produksiList = FXCollections.observableArrayList();
            mesinList = FXCollections.observableArrayList();
            tipeMesinList = FXCollections.observableArrayList();
            productList = FXCollections.observableArrayList();
            rawList = FXCollections.observableArrayList();
            tipeMaterialList = FXCollections.observableArrayList();

            var conn = DBConnection.get();
            var stmt = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            stmt.execute();

            rep_peran.deletePeran();
            rep_production.deleteProduksi();
            rep_emp.deleteEmployee();

            stmt = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
            stmt.execute();

            refreshTable();
            TABLE_EMP.setItems(employeeList);
            TABLE_PERAN.setItems(peranList);
            TABLE_PRODUKSI.setItems(produksiList);
            TABLE_MESIN.setItems(mesinList);
            TABLE_TIPE_MESIN.setItems(tipeMesinList);
            TABLE_PRODUCT.setItems(productList);
            TABLE_RAW.setItems(rawList);
            TABLE_TIPE_MATERIAL.setItems(tipeMaterialList);

        } catch (SQLException e) {
            System.out.println("Error: e");
            e.printStackTrace();
        }
    }

    @FXML
    public void refreshTable() throws SQLException {
        employeeList.setAll(rep_emp.getAll());
        peranList.setAll(rep_peran.getAll());
        produksiList.setAll(rep_production.getAll());
        mesinList.setAll(rep_mesin.getAll());
        tipeMesinList.setAll(rep_tipeMesin.getAll());
        productList.setAll(rep_product.getAll());
        rawList.setAll(rep_raw.getAll());
        tipeMaterialList.setAll(repTipeMaterial.getAll());
    }


    @FXML
    public void submit() throws Exception {
        String employeeName = textField.getText();
        rep_emp.createEmployee(new Employee(1, employeeName, "Puri", "13-Juni-2023", 1, 1));
        refreshTable();
    }

    @FXML
    public void submit1() throws Exception {
        String employeeName = textField1.getText();
        rep_peran.createPeran(new PeranEmployee(1, employeeName, "Executive"));
        refreshTable();
    }

    @FXML
    public void submit11() throws Exception {
        rep_production.createProduksi(new Produksi(1, 10000, 5, "Puri Lidah", 812, 30));
        refreshTable();
    }
}
//
//    /**
//     * @param table TableView.
//     * @param properties property pada model
//     * @param <T> model type (biarin kosong aja, selama sudah ada di declarationnya TableView)
//     */
//    private<T> void setPropertyValueFactories(TableView<T> table, String ...properties) {
//        var columns = table.getColumns();
//
//        assert properties.length == columns.size();
//
//        for (int i = 0; i < properties.length; i++) {
//            columns.get(i).setCellValueFactory(new PropertyValueFactory<>(properties[i]));
//        }
//    }
//}