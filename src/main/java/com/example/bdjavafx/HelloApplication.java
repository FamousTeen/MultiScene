package com.example.bdjavafx;

import com.example.bdjavafx.scenes.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * `static` artinya dia hidup selama aplikasi ini berjalan dari awal sampai akhir.
 * Arti lain, tidak perlu new HelloApplication utk akses variabel `static`.
 * Cukup `HelloApplication.getStage()` & `HelloApplication.getScene("...")`
 */
public class HelloApplication extends Application {

    private static Stage stage;
    public static Stage getStage() {
        return stage;
    }

    /**
     * Variable `scenes` di sini dibuat lazy (fungsi yang nge-new baru jalan ketika kita panggil).
     * Sehingga bisa dpt versi terbaru terus. Kalau perlu simpan `state` yang lama, maka bisa gunakan
     * Map<String, BaseScene> yang langsung di new (tidak lewat lambda).
     */
    private static Map<String, SceneConstructor> scenes;
    public static BaseScene getScene(String key) {
        return scenes.get(key).createScene(stage);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scenes = Map.of(
                "main", (s) -> new MainScene(),
                "create", (s) -> new CreateScene(),
                "update", (s) -> new UpdateScene()
        );

        HelloApplication.stage = stage;
        getScene("main").show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}