package com.penilaian;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection c = DBConnection.getConnection();
        if (c != null) {
            System.out.println("TEST: koneksi berhasil");
        } else {
            System.out.println("TEST: koneksi GAGAL");
        }
    }
}
