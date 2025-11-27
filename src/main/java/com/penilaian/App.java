package com.penilaian;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // MULAI DARI LOGIN
        FXMLLoader loader = new FXMLLoader(App.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Login Penilaian Karyawan");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
