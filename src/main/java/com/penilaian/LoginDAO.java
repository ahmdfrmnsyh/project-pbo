package com.penilaian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public LoginUser login(String username, String password) {

        String sql = "SELECT id_user, username, role " +
                     "FROM login " +
                     "WHERE username = ? AND password = ? AND status = 'Aktif'";


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) {
                System.out.println("DEBUG: Koneksi NULL!");
                return null;
            }

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new LoginUser(
                        rs.getInt("id_user"),
                        rs.getString("username"),
                        rs.getString("role")
                );
            } else {
                System.out.println("DEBUG: User tidak ditemukan.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
