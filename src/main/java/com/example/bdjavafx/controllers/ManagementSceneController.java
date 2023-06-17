package com.example.bdjavafx.controllers;

import com.example.bdjavafx.DBConnection;
import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.models.Mesin;
import com.example.bdjavafx.models.PeranEmployee;
import com.example.bdjavafx.models.Produksi;
import com.example.bdjavafx.repositories.EmployeeRepository;
import com.example.bdjavafx.repositories.MesinRepository;
import com.example.bdjavafx.repositories.PeranEmployeeRepository;
import com.example.bdjavafx.repositories.ProduksiRepository;
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
    public TableColumn<Mesin, Integer> ID_TIPE;
    @FXML
    public TableColumn<Mesin, Integer> ID_PRODUKSI2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            rep_emp = new EmployeeRepository();
            rep_peran = new PeranEmployeeRepository();
            rep_production = new ProduksiRepository();
            rep_mesin = new MesinRepository();

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
            ID_TIPE.setCellValueFactory(new PropertyValueFactory<>("idTipe"));
            ID_PRODUKSI2.setCellValueFactory(new PropertyValueFactory<>("idProduksi"));

            employeeList = FXCollections.observableArrayList();
            peranList = FXCollections.observableArrayList();
            produksiList = FXCollections.observableArrayList();
            mesinList = FXCollections.observableArrayList();

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