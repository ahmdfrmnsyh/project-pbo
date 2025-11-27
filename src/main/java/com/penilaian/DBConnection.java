package com.penilaian;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL  = "jdbc:mysql://127.0.0.1:3306/kinerja_karyawan?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Koneksi OK: " + conn);  // debug
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
