package com.example.bdjavafx.controllers;

import com.example.bdjavafx.HelloApplication;
import javafx.fxml.FXML;
import java.io.IOException;

public class SecondSceneController  {
    @FXML
    public void toPembelian() throws IOException {
        HelloApplication.getScene("pembelian").show();
    }
}
