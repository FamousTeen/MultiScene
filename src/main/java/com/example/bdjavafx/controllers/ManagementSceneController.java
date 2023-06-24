package com.example.bdjavafx.controllers;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.HelloApplication;
import com.example.bdjavafx.models.*;
import com.example.bdjavafx.repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagementSceneController implements Initializable {
    // Employee
    public EmployeeRepository rep_emp;
    protected ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    // Peran_employee
    protected PeranEmployeeRepository rep_peran;
    protected ObservableList<PeranEmployee> peranList = FXCollections.observableArrayList();;

    // Produksi
    protected ProduksiRepository rep_production;
    protected ObservableList<Produksi> produksiList = FXCollections.observableArrayList();;

    // Mesin
    protected MesinRepository rep_mesin;
    protected ObservableList<Mesin> mesinList = FXCollections.observableArrayList();;

    // Tipe_mesin
    protected TipeMesinRepository rep_tipeMesin;
    protected ObservableList<TipeMesin> tipeMesinList = FXCollections.observableArrayList();;

    // Product
    protected ProductRepository rep_product;
    protected ObservableList<Product> productList = FXCollections.observableArrayList();;

    // Raw Material
    protected RawMaterialRepository rep_raw;
    protected ObservableList<RawMaterial> rawList = FXCollections.observableArrayList();

    // Tipe Material
    protected  TipeMaterialRepository repTipeMaterial;
    protected ObservableList<TipeMaterial> tipeMaterialList = FXCollections.observableArrayList();;

    @FXML
    public  TableView<Employee> TABLE_EMP;
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

//    private UpdateSceneController updateSceneController;

//    public void setUpdateSceneController(UpdateSceneController controller) {
//        this.updateSceneController = controller;
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            rep_emp = new EmployeeRepository();
            rep_production = new ProduksiRepository();
            rep_product = new ProductRepository();
            rep_mesin = new MesinRepository();
            repTipeMaterial = new TipeMaterialRepository();
            rep_raw = new RawMaterialRepository();
            rep_tipeMesin = new TipeMesinRepository();
            rep_peran = new PeranEmployeeRepository();

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
            MASSA_MATERIAL.setCellValueFactory(new PropertyValueFactory<>("massaMaterial"));
            JUMLAH_MATERIAL.setCellValueFactory(new PropertyValueFactory<>("jumlahMaterial"));
            ID_TIPE_FK2.setCellValueFactory(new PropertyValueFactory<>("idTipe"));
            ID_PRODUKSI4.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));

            // TABLE TIPE_MATERIAL
            ID_TIPE_PK2.setCellValueFactory(new PropertyValueFactory<>("idTipe"));
            NAMA_TIPE.setCellValueFactory(new PropertyValueFactory<>("namaTipe"));
            RECYCLE_TYPE.setCellValueFactory(new PropertyValueFactory<>("recycleType"));

//            TABLE_EMP.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_PERAN.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_RAW.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_PRODUKSI.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_PERAN.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_TIPE_MESIN.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_TIPE_MATERIAL.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_MESIN.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });
//            TABLE_PRODUCT.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
////                    UpdateSceneController.setData(newValue);
////                    UpdateSceneController.setData(newValue);
//                }
//            });

            var conn = DBConnection.get();
            var stmt = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            stmt.execute();
//            rep_peran.deletePeran();
////            rep_production.deleteProduksi();
////            rep_emp.deleteEmployee();
//

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
    TextField textField;
    @FXML
    TextField textField1;
    @FXML
    TextField textField2;

    @FXML
    public void toCreateScene() throws IOException {
        HelloApplication.getScene("create").show();
    }

    @FXML
    public void toUpdateScene() throws IOException {
            Employee selectedData1 = TABLE_EMP.getSelectionModel().getSelectedItem();
            if (selectedData1 != null) {
                setFieldAndText("ID Employee","Nama Employee", "Alamat",
                        "Tanggal Lahir", "ID Peran", "ID Produksi", true, true,
                        true, true, true, true);
                FIELD_1.setText(String.valueOf(selectedData1.getIdEmployee()));
                FIELD_2.setText(selectedData1.getNamaEmployee());
                FIELD_3.setText(selectedData1.getAlamat());
                FIELD_4.setText(selectedData1.getTglLahir());
                FIELD_5.setText(String.valueOf(selectedData1.getIdPeran()));
                FIELD_6.setText(String.valueOf(selectedData1.getIdProduksi()));
            }
            RawMaterial selectedData2 = TABLE_RAW.getSelectionModel().getSelectedItem();
            if (selectedData2 != null) {
                setFieldAndText("ID Material", "Massa Material",
                    "Jumlah Material", "ID Tipe", "ID Produksi", null,  false, true,
                    true, true, true, false);
                FIELD_1.setText(String.valueOf(selectedData2.getIdMaterial()));
                FIELD_2.setText(String.valueOf(selectedData2.getMassaMaterial()));
                FIELD_3.setText(String.valueOf(selectedData2.getJumlahMaterial()));
                FIELD_4.setText(String.valueOf(selectedData2.getIdTipe()));
                FIELD_5.setText(String.valueOf(selectedData2.getIdProduksi()));
            }
            Product selectedData3 = TABLE_PRODUCT.getSelectionModel().getSelectedItem();
            if (selectedData3 != null) {
                setFieldAndText("ID Produk", "Tanggal Buat", "Harga Produk",
                        "Massa Produk", "ID Produksi", null, false, true,
                        true, true, true, false);
                FIELD_1.setText(String.valueOf(selectedData3.getIdProduct()));
                FIELD_2.setText(selectedData3.getTglBuat());
                FIELD_3.setText(String.valueOf(selectedData3.getHargaProduk()));
                FIELD_4.setText(String.valueOf(selectedData3.getMassaProduk()));
                FIELD_5.setText(String.valueOf(selectedData3.getIdProduksi()));
            }
            Produksi selectedData4 = TABLE_PRODUKSI.getSelectionModel().getSelectedItem();
            if (selectedData4 != null) {
                setFieldAndText("ID Produksi","Biaya Produksi", "Jumlah Employee",
                        "Alamat Warehouse", "No Telepon", "Kapasitas Ruang", false, true,
                        true, true, true, true);
                FIELD_1.setText(String.valueOf(selectedData4.getIdProduksi()));
                FIELD_2.setText(String.valueOf(selectedData4.getBiayaProduksi()));
                FIELD_3.setText(String.valueOf(selectedData4.getJumlahEmployee()));
                FIELD_4.setText(selectedData4.getAlamatWH());
                FIELD_5.setText(String.valueOf(selectedData4.getNoTelp()));
                FIELD_6.setText(String.valueOf(selectedData4.getKapasitasRuang()));
            }
            Mesin selectedData5 = TABLE_MESIN.getSelectionModel().getSelectedItem();
            if (selectedData5 != null) {
                setFieldAndText("ID Mesin", "Kapasitas Mesin", "Harga Mesin",
                        "ID Tipe", "ID Produksi", null, true, true,
                        true, true, true, false);
                FIELD_1.setText(String.valueOf(selectedData5.getIdMesin()));
                FIELD_2.setText(String.valueOf(selectedData5.getKapasitasMesin()));
                FIELD_3.setText(String.valueOf(selectedData5.getHargaMesin()));
                FIELD_4.setText(String.valueOf(selectedData5.getIdTipe()));
                FIELD_5.setText(String.valueOf(selectedData5.getIdProduksi()));
            }
            PeranEmployee selectedData6 = TABLE_PERAN.getSelectionModel().getSelectedItem();
            if (selectedData6 != null) {
                setFieldAndText("ID Peran", "Nama Peran", "Jabatan", null, null,
                        null, true, true, true, false, false, false);
                FIELD_1.setText(String.valueOf(selectedData6.getIdPeran()));
                FIELD_2.setText(selectedData6.getNamaPeran());
                FIELD_3.setText(selectedData6.getJabatan());
            }
            TipeMaterial selectedData7 = TABLE_TIPE_MATERIAL.getSelectionModel().getSelectedItem();
            if (selectedData7 != null) {
                setFieldAndText("ID Tipe","Nama Tipe", "Recycle Type", null, null,
                        null, false, true, true, false, false, false);
                FIELD_1.setText(String.valueOf(selectedData7.getIdTipe()));
                FIELD_2.setText(selectedData7.getNamaTipe());
                FIELD_3.setText(selectedData7.getRecycleType());
            }
            TipeMesin selectedData8 = TABLE_TIPE_MESIN.getSelectionModel().getSelectedItem();
            if (selectedData8 != null) {
                setFieldAndText("ID Tipe", "Fungsi Mesin", "Cara Kerja", null, null,
                        null, true, true, true, false, false, false);
                FIELD_1.setText(String.valueOf(selectedData8.getId_tipe()));
                FIELD_2.setText(selectedData8.getFungsi_mesin());
                FIELD_3.setText(selectedData8.getCara_kerja());
            }
        HelloApplication.getScene("update").show();
    }

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
    public void submit() throws Exception {
        Employee selectedData1 = TABLE_EMP.getSelectionModel().getSelectedItem();
        if (selectedData1 != null) {
            int id = Integer.parseInt(FIELD_1.getText());
            String nama = FIELD_2.getText();
            String alamat = FIELD_3.getText();
            String tglLahir = FIELD_4.getText();
            int idPeran = Integer.parseInt(FIELD_5.getText());
            int idProduksi = Integer.parseInt(FIELD_6.getText());
            rep_emp.updateEmployee(new Employee(id, nama, alamat, tglLahir, idPeran, idProduksi));
            refreshTable();
        }
        RawMaterial selectedData2 = TABLE_RAW.getSelectionModel().getSelectedItem();
        if (selectedData2 != null) {
            setFieldAndText("ID Material", "Massa Material",
                    "Jumlah Material", "ID Tipe", "ID Produksi", null,  false, true,
                    true, true, true, false);
            FIELD_1.setText(String.valueOf(selectedData2.getIdMaterial()));
            FIELD_2.setText(String.valueOf(selectedData2.getMassaMaterial()));
            FIELD_3.setText(String.valueOf(selectedData2.getJumlahMaterial()));
            FIELD_4.setText(String.valueOf(selectedData2.getIdTipe()));
            FIELD_5.setText(String.valueOf(selectedData2.getIdProduksi()));
        }
        Product selectedData3 = TABLE_PRODUCT.getSelectionModel().getSelectedItem();
        if (selectedData3 != null) {
            int id = Integer.parseInt(FIELD_1.getText());
            String tglbuat = FIELD_2.getText();
            int harga = Integer.parseInt(FIELD_3.getText());
            int massa = Integer.parseInt(FIELD_4.getText());
            int idProduksi = Integer.parseInt(FIELD_5.getText());
            rep_product.updateProduct(new Product(id, tglbuat, harga, massa, idProduksi));
            refreshTable();
        }
        Produksi selectedData4 = TABLE_PRODUKSI.getSelectionModel().getSelectedItem();
        if (selectedData4 != null) {
            setFieldAndText("ID Produksi","Biaya Produksi", "Jumlah Employee",
                    "Alamat Warehouse", "No Telepon", "Kapasitas Ruang", false, true,
                    true, true, true, true);
            FIELD_1.setText(String.valueOf(selectedData4.getIdProduksi()));
            FIELD_2.setText(String.valueOf(selectedData4.getBiayaProduksi()));
            FIELD_3.setText(String.valueOf(selectedData4.getJumlahEmployee()));
            FIELD_4.setText(selectedData4.getAlamatWH());
            FIELD_5.setText(String.valueOf(selectedData4.getNoTelp()));
            FIELD_6.setText(String.valueOf(selectedData4.getKapasitasRuang()));
        }
        Mesin selectedData5 = TABLE_MESIN.getSelectionModel().getSelectedItem();
        if (selectedData5 != null) {
            int id = Integer.parseInt(FIELD_1.getText());
            int kapasitas = Integer.parseInt(FIELD_2.getText());
            int harga = Integer.parseInt(FIELD_3.getText());
            int idTipe = Integer.parseInt(FIELD_4.getText());
            int idProduksi = Integer.parseInt(FIELD_5.getText());
            rep_mesin.updateMesin(new Mesin(id, kapasitas, harga, idTipe, idProduksi));
            refreshTable();
        }
        PeranEmployee selectedData6 = TABLE_PERAN.getSelectionModel().getSelectedItem();
        if (selectedData6 != null) {
            int id = Integer.parseInt(FIELD_1.getText());
            String nama = FIELD_2.getText();
            String jabatan = FIELD_3.getText();
            rep_peran.updatePeran(new PeranEmployee(id, nama, jabatan));
            refreshTable();
        }
        TipeMaterial selectedData7 = TABLE_TIPE_MATERIAL.getSelectionModel().getSelectedItem();
        if (selectedData7 != null) {
            setFieldAndText("ID Tipe","Nama Tipe", "Recycle Type", null, null,
                    null, false, true, true, false, false, false);
            FIELD_1.setText(String.valueOf(selectedData7.getIdTipe()));
            FIELD_2.setText(selectedData7.getNamaTipe());
            FIELD_3.setText(selectedData7.getRecycleType());
        }
        TipeMesin selectedData8 = TABLE_TIPE_MESIN.getSelectionModel().getSelectedItem();
        if (selectedData8 != null) {
            setFieldAndText("ID Tipe", "Fungsi Mesin", "Cara Kerja", null, null,
                    null, true, true, true, false, false, false);
            FIELD_1.setText(String.valueOf(selectedData8.getId_tipe()));
            FIELD_2.setText(selectedData8.getFungsi_mesin());
            FIELD_3.setText(selectedData8.getCara_kerja());
        }
    }
}
//
//    /**
//     * @param table TableView.
//     * @param properties property pada model
//     * @param <T> model type (biarin kosong aja, selama sudah ada di declarationnya TableView)
//     */
//    protected<T> void setPropertyValueFactories(TableView<T> table, String ...properties) {
//        var columns = table.getColumns();
//
//        assert properties.length == columns.size();
//
//        for (int i = 0; i < properties.length; i++) {
//            columns.get(i).setCellValueFactory(new PropertyValueFactory<>(properties[i]));
//        }
//    }
//}

