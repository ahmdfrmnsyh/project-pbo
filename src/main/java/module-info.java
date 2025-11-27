module PenilaianKaryawanFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.penilaian to javafx.fxml;
    exports com.penilaian;
}
