package com.penilaian;

public class LoginUser {

    private int idUser;
    private String username;
    private String role;

    public LoginUser(int idUser, String username, String role) {
        this.idUser = idUser;
        this.username = username;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
