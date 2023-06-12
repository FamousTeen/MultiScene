module com.example.bdjavafx {

    /**
     * Module-info ini berisi bagian mana yang di-export.
     * Karena modul external spt javafx.base, javafx.fxml perlu mengakses modul project (lihat di yg `opens...`)
     * `requires...` untuk include library external ke project
     * Sedangkan `exports...` supaya modul tersebut dpt dilihat oleh modul lain di project.
     */
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.bdjavafx to javafx.base, javafx.fxml;
    opens com.example.bdjavafx.models to javafx.base, javafx.fxml;
    opens com.example.bdjavafx.scenes to javafx.base, javafx.fxml;
    opens com.example.bdjavafx.controllers to javafx.base, javafx.fxml;

    exports com.example.bdjavafx;
    exports com.example.bdjavafx.models;
    exports com.example.bdjavafx.controllers;
    exports com.example.bdjavafx.scenes;
}