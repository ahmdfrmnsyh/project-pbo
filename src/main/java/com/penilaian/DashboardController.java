package com.penilaian;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblWelcome;

    private LoginUser loginUser;

    public void setLoginUser(LoginUser user) {
        this.loginUser = user;
        lblWelcome.setText("Selamat datang, " + user.getUsername() +
                           " (" + user.getRole() + ")");
    }
}
