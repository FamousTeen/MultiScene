package com.example.bdjavafx.scenes;

import com.example.bdjavafx.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * BaseScene menyimplikasi apa yang kita perlu lakukan untuk membuat scene.
 * Tiap scene baru tinggal inherit dari sini + isi member variabel selain `stage` di constructor.
 * Lihat `PembelianScene` dan `SecondScene` untuk contoh.
 */
public abstract class BaseScene {
    protected String title;
    protected Stage stage;
    protected String viewName;
    protected int width, height;

    public BaseScene() {
        this.stage = HelloApplication.getStage();
    }

    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(viewName));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
