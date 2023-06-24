//package com.example.bdjavafx.controllers;
//
//import com.example.bdjavafx.DBConnection;
//import com.example.bdjavafx.HelloApplication;
//import com.example.bdjavafx.models.*;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//public class UpdateSceneController implements Initializable {
//      //   TEXT COLUMN
//      @FXML
//      public  Label TEXT_1;
//      @FXML
//      public Label TEXT_22;
//      @FXML
//      public  Label TEXT_3 = new Label();
//      @FXML
//      public  Label TEXT_4 = new Label();
//      @FXML
//      public  Label TEXT_5 = new Label();
//      @FXML
//      public  Label TEXT_6 = new Label();
//
//      //  FIELD (DATA KOLOM)
//      @FXML
//      public  TextField FIELD_1 = new TextField();
//      @FXML
//      public  TextField FIELD_2 = new TextField("djnfnd");
//      @FXML
//      public  TextField FIELD_3 = new TextField();
//      @FXML
//      public  TextField FIELD_4 = new TextField();
//      @FXML
//      public  TextField FIELD_5 = new TextField();
//      @FXML
//      public  TextField FIELD_6 = new TextField();
//
//      //  TEXT UNTUK STATUS PERUBAHAN
//      @FXML
//      private Label STATUS_TEXT;
//
//      // VARIABLE (Untuk mengetahui tabel mana yang ingin diganti)
//      public String statusTable;
//
//      private static Employee selectedData1;
//      private static RawMaterial selectedData2;
//      private static Product selectedData3;
//      private static Produksi selectedData4;
//      private static Mesin selectedData5;
//      private static PeranEmployee selectedData6;
//      private static TipeMaterial selectedData7;
//      private static TipeMesin selectedData8;
//
//      @Override
//      public void initialize(URL url, ResourceBundle resourceBundle) {
//         if (selectedData1 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Employee","Nama Employee", "Alamat",
//                    "Tanggal Lahir", "ID Peran", "ID Produksi", true, true,
//                    true, true, true, true);
//            FIELD_1.setText(String.valueOf(selectedData1.getIdEmployee()));
//            FIELD_2.setText(selectedData1.getNamaEmployee());
//            FIELD_3.setText(selectedData1.getAlamat());
//            FIELD_4.setText(selectedData1.getTglLahir());
//            FIELD_5.setText(String.valueOf(selectedData1.getIdPeran()));
//            FIELD_6.setText(String.valueOf(selectedData1.getIdProduksi()));
//         }
//         if (selectedData2 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Material", "Massa Material",
//                    "Jumlah Material", "ID Tipe", "ID Produksi", null,  false, true,
//                    true, true, true, false);
//            FIELD_1.setText(String.valueOf(selectedData2.getIdMaterial()));
//            FIELD_2.setText(String.valueOf(selectedData2.getMassaMaterial()));
//            FIELD_3.setText(String.valueOf(selectedData2.getJumlahMaterial()));
//            FIELD_4.setText(String.valueOf(selectedData2.getIdTipe()));
//            FIELD_5.setText(String.valueOf(selectedData2.getIdProduksi()));
//         }
//         if (selectedData3 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Produk", "Tanggal Buat", "Harga Produk",
//                    "Massa Produk", "ID Produksi", null, false, true,
//                    true, true, true, false);
//            FIELD_1.setText(String.valueOf(selectedData3.getIdProduct()));
//            FIELD_2.setText(selectedData3.getTglBuat());
//            FIELD_3.setText(String.valueOf(selectedData3.getHargaProduk()));
//            FIELD_4.setText(String.valueOf(selectedData3.getMassaProduk()));
//            FIELD_5.setText(String.valueOf(selectedData3.getIdProduksi()));
//         }
//         if (selectedData4 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Produksi","Biaya Produksi", "Jumlah Employee",
//                    "Alamat Warehouse", "No Telepon", "Kapasitas Ruang", false, true,
//                    true, true, true, true);
//            FIELD_1.setText(String.valueOf(selectedData4.getIdProduksi()));
//            FIELD_2.setText(String.valueOf(selectedData4.getBiayaProduksi()));
//            FIELD_3.setText(String.valueOf(selectedData4.getJumlahEmployee()));
//            FIELD_4.setText(selectedData4.getAlamatWH());
//            FIELD_5.setText(String.valueOf(selectedData4.getNoTelp()));
//            FIELD_6.setText(String.valueOf(selectedData4.getKapasitasRuang()));
//         }
//         if (selectedData5 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Mesin", "Kapasitas Mesin", "Harga Mesin",
//                    "ID Tipe", "ID Produksi", null, true, true,
//                    true, true, true, false);
//            FIELD_1.setText(String.valueOf(selectedData5.getIdMesin()));
//            FIELD_2.setText(String.valueOf(selectedData5.getKapasitasMesin()));
//            FIELD_3.setText(String.valueOf(selectedData5.getHargaMesin()));
//            FIELD_4.setText(String.valueOf(selectedData5.getIdTipe()));
//            FIELD_5.setText(String.valueOf(selectedData5.getIdProduksi()));
//         }
//         if (selectedData6 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Peran", "Nama Peran", "Jabatan", null, null,
//                    null, true, true, true, false, false, false);
//            FIELD_1.setText(String.valueOf(selectedData6.getIdPeran()));
//            FIELD_2.setText(selectedData6.getNamaPeran());
//            FIELD_3.setText(selectedData6.getJabatan());
//         }
//         if (selectedData7 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Tipe","Nama Tipe", "Recycle Type", null, null,
//                    null, false, true, true, false, false, false);
//            FIELD_1.setText(String.valueOf(selectedData7.getIdTipe()));
//            FIELD_2.setText(selectedData7.getNamaTipe());
//            FIELD_3.setText(selectedData7.getRecycleType());
//         }
//         if (selectedData8 != null) {
////                UpdateSceneController.setData(selectedData);
//            setFieldAndText("ID Tipe", "Fungsi Mesin", "Cara Kerja", null, null,
//                    null, true, true, true, false, false, false);
//            FIELD_1.setText(String.valueOf(selectedData8.getId_tipe()));
//            FIELD_2.setText(selectedData8.getFungsi_mesin());
//            FIELD_3.setText(selectedData8.getCara_kerja());
//         }
//      }
//   public static void setData(Employee data) {
////      setFieldAndText("ID Employee","Nama Employee", "Alamat",
////              "Tanggal Lahir", "ID Peran", "ID Produksi", true, true,
////              true, true, true, true);
////      FIELD_1.setText(String.valueOf(data.getIdEmployee()));
////      FIELD_2.setText(data.getNamaEmployee());
////      FIELD_3.setText(data.getAlamat());
////      FIELD_4.setText(data.getTglLahir());
////      FIELD_5.setText(String.valueOf(data.getIdPeran()));
////      FIELD_6.setText(String.valueOf(data.getIdProduksi()));
//      selectedData1 = data;
//   }
//
//   public static void setData(RawMaterial data) {
////      setFieldAndText("ID Material", "Massa Material",
////              "Jumlah Material", "ID Tipe", "ID Produksi", null,  false, true,
////              true, true, true, false);
////      FIELD_1.setText(String.valueOf(data.getIdMaterial()));
////      FIELD_2.setText(String.valueOf(data.getMassaMaterial()));
////      FIELD_3.setText(String.valueOf(data.getJumlahMaterial()));
////      FIELD_4.setText(String.valueOf(data.getIdTipe()));
////      FIELD_5.setText(String.valueOf(data.getIdProduksi()));
//      selectedData2 = data;
//   }
//
//   public static void setData(Product data) {
////      setFieldAndText("ID Produk", "Tanggal Buat", "Harga Produk",
////              "Massa Produk", "ID Produksi", null, false, true,
////              true, true, true, false);
////      FIELD_1.setText(String.valueOf(data.getIdProduct()));
////      FIELD_2.setText(data.getTglBuat());
////      FIELD_3.setText(String.valueOf(data.getHargaProduk()));
////      FIELD_4.setText(String.valueOf(data.getMassaProduk()));
////      FIELD_5.setText(String.valueOf(data.getIdProduksi()));
//      selectedData3 = data;
//   }
//
//   public static void setData(Produksi data) {
////      setFieldAndText("ID Produksi","Biaya Produksi", "Jumlah Employee",
////              "Alamat Warehouse", "No Telepon", "Kapasitas Ruang", false, true,
////              true, true, true, true);
////      FIELD_1.setText(String.valueOf(data.getIdProduksi()));
////      FIELD_2.setText(String.valueOf(data.getBiayaProduksi()));
////      FIELD_3.setText(String.valueOf(data.getJumlahEmployee()));
////      FIELD_4.setText(data.getAlamatWH());
////      FIELD_5.setText(String.valueOf(data.getNoTelp()));
////      FIELD_6.setText(String.valueOf(data.getKapasitasRuang()));
//      selectedData4 = data;
//   }
//
//   public static void setData(Mesin data) {
////      setFieldAndText("ID Mesin", "Kapasitas Mesin", "Harga Mesin",
////              "ID Tipe", "ID Produksi", null, true, true,
////              true, true, true, false);
////      FIELD_1.setText(String.valueOf(data.getIdMesin()));
////      FIELD_2.setText(String.valueOf(data.getKapasitasMesin()));
////      FIELD_3.setText(String.valueOf(data.getHargaMesin()));
////      FIELD_4.setText(String.valueOf(data.getIdTipe()));
////      FIELD_5.setText(String.valueOf(data.getIdProduksi()));
//      selectedData5 = data;
//   }
//
//   public static void setData(PeranEmployee data) {
////      setFieldAndText("ID Peran", "Nama Peran", "Jabatan", null, null,
////              null, true, true, true, false, false, false);
////      FIELD_1.setText(String.valueOf(data.getIdPeran()));
////      FIELD_2.setText(data.getNamaPeran());
////      FIELD_3.setText(data.getJabatan());
//      selectedData6 = data;
//   }
//
//   public static void setData(TipeMaterial data) {
////      setFieldAndText("ID Tipe","Nama Tipe", "Recycle Type", null, null,
////              null, false, true, true, false, false, false);
////      FIELD_1.setText(String.valueOf(data.getIdTipe()));
////      FIELD_2.setText(data.getNamaTipe());
////      FIELD_3.setText(data.getRecycleType());
//      selectedData7 = data;
//   }
//
//   public static void setData(TipeMesin data) {
////      setFieldAndText("ID Tipe", "Fungsi Mesin", "Cara Kerja", null, null,
////              null, true, true, true, false, false, false);
////      FIELD_1.setText(String.valueOf(data.getId_tipe()));
////      FIELD_2.setText(data.getFungsi_mesin());
////      FIELD_3.setText(data.getCara_kerja());
//      selectedData8 = data;
//   }
//
//
//      @FXML
//      public void clear() {
//         FIELD_1.setText(null);
//         FIELD_2.setText(null);
//         FIELD_3.setText(null);
//         FIELD_4.setText(null);
//         FIELD_5.setText(null);
//         FIELD_6.setText(null);
//      }
//
//      @FXML
//      public void submit () {
//         if (Objects.equals(statusTable, "employee")) {
//            try {
//               ManagementSceneController.rep_emp.updateEmployee(ManagementSceneController.TABLE_EMP.getSelectionModel().getSelectedItem());
//               ManagementSceneController.refreshTable();
//            } catch (SQLException s) {
//               System.out.println("Error " + s);
//            }
//            STATUS_TEXT.setText("1 row is updated to EMPLOYEE");
//            STATUS_TEXT.setVisible(true);
//         }
////         } else if (selectedOption.equals("Mesin")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            int kapasitas = Integer.parseInt(FIELD_2.getText());
////            int harga = Integer.parseInt(FIELD_3.getText());
////            int idTipe = Integer.parseInt(FIELD_4.getText());
////            int idProduksi = Integer.parseInt(FIELD_5.getText());
////            try {
////               rep_mesin.createMesin(new Mesin(id, kapasitas, harga, idTipe, idProduksi));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to MESIN");
////            STATUS_TEXT.setVisible(true);
////         } else if (selectedOption.equals("Peran Employee")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            String nama = FIELD_2.getText();
////            String jabatan = FIELD_3.getText();
////            try {
////               rep_peran.createPeran(new PeranEmployee(id, nama, jabatan));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to PERAN_EMPLOYEE");
////            STATUS_TEXT.setVisible(true);
////         } else if (selectedOption.equals("Product")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            String tglBuat = FIELD_2.getText();
////            int harga = Integer.parseInt(FIELD_3.getText());
////            int massa = Integer.parseInt(FIELD_4.getText());
////            int idProduksi = Integer.parseInt(FIELD_5.getText());
////            try {
////               rep_product.createProduct(new Product(id, tglBuat, harga, massa, idProduksi));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to PRODUCT");
////            STATUS_TEXT.setVisible(true);
////         } else if (selectedOption.equals("Produksi")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            int biaya = Integer.parseInt(FIELD_2.getText());
////            int jumlahEmp = Integer.parseInt(FIELD_3.getText());
////            String alamatWH = FIELD_4.getText();
////            int noTelp = Integer.parseInt(FIELD_5.getText());
////            int kapasitas = Integer.parseInt(FIELD_6.getText());
////            try {
////               rep_production.createProduksi(new Produksi(id, biaya, jumlahEmp, alamatWH, noTelp, kapasitas));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to PRODUKSI");
////            STATUS_TEXT.setVisible(true);
////         } else if (selectedOption.equals("Raw Material")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            int massa = Integer.parseInt(FIELD_2.getText());
////            int jumlah = Integer.parseInt(FIELD_3.getText());
////            int idTipe = Integer.parseInt(FIELD_4.getText());
////            int idProduksi = Integer.parseInt(FIELD_5.getText());
////            try {
////               rep_raw.createRawMaterial(new RawMaterial(id, massa, jumlah, idTipe, idProduksi));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to RAW_MATERIAL");
////            STATUS_TEXT.setVisible(true);
////         } else if (selectedOption.equals("Tipe Material")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            String nama = FIELD_2.getText();
////            String recycleType = FIELD_3.getText();
////            try {
////               repTipeMaterial.createTipeMaterial(new TipeMaterial(id, nama, recycleType));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to TIPE_MATERIAL");
////            STATUS_TEXT.setVisible(true);
////         } else if (selectedOption.equals("Tipe Mesin")) {
////            STATUS_TEXT.setVisible(false);
////            int id = Integer.parseInt(FIELD_1.getText());
////            String fungsi = FIELD_2.getText();
////            String caraKerja = FIELD_3.getText();
////            try {
////               rep_tipeMesin.createTipeMesin(new TipeMesin(id, fungsi, caraKerja));
////               refreshTable();
////            } catch (SQLException s) {
////               System.out.println("Error " + s);
////            }
////            STATUS_TEXT.setText("1 row is added to TIPE_MESIN");
////            STATUS_TEXT.setVisible(true);
////         }
//      }
//
//      public void disableAll () { // membuat semua field dan text invisible
//         TEXT_1.setVisible(false);
//         TEXT_22.setVisible(false);
//         TEXT_3.setVisible(false);
//         TEXT_4.setVisible(false);
//         TEXT_5.setVisible(false);
//         TEXT_6.setVisible(false);
//         FIELD_1.setVisible(false);
//         FIELD_2.setVisible(false);
//         FIELD_3.setVisible(false);
//         FIELD_4.setVisible(false);
//         FIELD_5.setVisible(false);
//         FIELD_6.setVisible(false);
//         STATUS_TEXT.setVisible(false);
//      }
//
//
//      //  untuk mengsetting semua field and text
//      public void setFieldAndText(String column1, String column2, String column3,
//                                         String column4, String column5, String column6,
//                                         boolean isVisible1, boolean isVisible2, boolean isVisible3,
//                                         boolean isVisible4, boolean isVisible5, boolean isVisible6) {
//         TEXT_1.setText(column1);
//         TEXT_22.setText(column2);
//         TEXT_3.setText(column3);
//         TEXT_4.setText(column4);
//         TEXT_5.setText(column5);
//         TEXT_6.setText(column6);
//         TEXT_1.setVisible(isVisible1);
//         TEXT_22.setVisible(isVisible2);
//         TEXT_3.setVisible(isVisible3);
//         TEXT_4.setVisible(isVisible4);
//         TEXT_5.setVisible(isVisible5);
//         TEXT_6.setVisible(isVisible6);
//         FIELD_1.setVisible(isVisible1);
//         FIELD_2.setVisible(isVisible2);
//         FIELD_3.setVisible(isVisible3);
//         FIELD_4.setVisible(isVisible4);
//         FIELD_5.setVisible(isVisible5);
//         FIELD_6.setVisible(isVisible6);
//      }
//
//      @FXML
//      public void toPembelian() throws IOException {
//         HelloApplication.getScene("main").show();
//      }
//
//
//}
