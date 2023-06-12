package com.example.bdjavafx.controllers;

import com.example.bdjavafx.models.Employee;
import com.example.bdjavafx.repositories.EmployeeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagementSceneController implements Initializable {

    private EmployeeRepository repository;
    private ObservableList<Employee> employeeList;

    @FXML
    public TextField textField;
    @FXML
    public TableView<Employee> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       try {
           employeeList = FXCollections.observableArrayList();
           repository = new EmployeeRepository();

           setPropertyValueFactories(
                   tableView,
                   "idPembelian", "employeeName", "brgDibeli", "customerID"
           );

           refreshTable();

           tableView.setItems(pembelianList);

       } catch (Exception e) {
            System.out.println("Error:" + e);
            e.printStackTrace();
       }
    }

    public void refreshTable() throws SQLException {
        pembelianList.setAll(repository.getAll());
    }

    @FXML
    public void submit(ActionEvent actionEvent) throws Exception {
        String employeeName = textField.getText();
        repository.createPembelian(new Employee(0, employeeName, "Pensil", 10));
        refreshTable();
    }

    /**
     * @param table TableView.
     * @param properties property pada model
     * @param <T> model type (biarin kosong aja, selama sudah ada di declarationnya TableView)
     */
    private<T> void setPropertyValueFactories(TableView<T> table, String ...properties) {
        var columns = table.getColumns();

        assert properties.length == columns.size();

        for (int i = 0; i < properties.length; i++) {
            columns.get(i).setCellValueFactory(new PropertyValueFactory<>(properties[i]));
        }
    }
}