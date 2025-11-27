package com.penilaian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;
    @FXML private Label lblStatus;
    @FXML private Button btnLogin;

    private final LoginDAO loginDAO = new LoginDAO();

    @FXML
    private void handleLogin() {
        String user = txtUser.getText().trim();
        String pass = txtPass.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            lblStatus.setText("Username dan password wajib diisi!");
            lblStatus.setStyle("-fx-text-fill: red;");
            return;
        }

        lblStatus.setText("Memeriksa akun...");
        lblStatus.setStyle("-fx-text-fill: orange;");

        LoginUser lu = loginDAO.login(user, pass);

        if (lu == null) {
            lblStatus.setText("Login gagal! Periksa username / password.");
            lblStatus.setStyle("-fx-text-fill: red;");
            return;
        }

        lblStatus.setText("Login berhasil, membuka dashboard...");
        lblStatus.setStyle("-fx-text-fill: green;");

        openDashboard(lu);
    }

    private void openDashboard(LoginUser lu) {
        try {
            System.out.println("DEBUG: Membuka Dashboard.fxml ...");
            FXMLLoader loader = new FXMLLoader(App.class.getResource("Dashboard.fxml"));
            Parent root = loader.load();

            System.out.println("DEBUG: Dashboard.fxml berhasil di-load");

            DashboardController controller = loader.getController();
            controller.setLoginUser(lu);

            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard Penilaian Karyawan");
            stage.setResizable(true);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            lblStatus.setText("Error saat membuka dashboard (lihat Output).");
            lblStatus.setStyle("-fx-text-fill: red;");
        }
    }
}
