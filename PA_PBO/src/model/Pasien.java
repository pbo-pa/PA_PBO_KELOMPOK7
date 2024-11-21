/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pasien extends User {
    public Pasien(String id_akun, String username, String password, String role) {
        super(id_akun, username, password, role);
    }
   
    @Override
    public void simpanUser() {
        // Save to `user` table
        String userSql = "INSERT INTO user (id_akun, username, password, role) VALUES (?, ?, ?, ?)";
        String pasienSql = "INSERT INTO pasien (id_akun) VALUES (?)";

        try (Connection conn = KoneksiDatabase.getKoneksi()) {
            try (PreparedStatement stmt = conn.prepareStatement(userSql)) {
                stmt.setString(1, id_akun);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.setString(4, role);
                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(pasienSql)) {
                stmt.setString(1, id_akun);
                stmt.executeUpdate();
            }

            System.out.println("Data pasien berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Pasien cariPasienBerdasarkanId(String id_akun) {
        User user = cariUserBerdasarkanId(id_akun);
        if (user != null) {
            return new Pasien(user.id_akun, user.username, user.password, user.role);
        }
        return null;
    }

    public void hapusPasien() {
        hapusUser();
        String sql = "DELETE FROM pasien WHERE id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_akun);
            stmt.executeUpdate();
            System.out.println("Data pasien berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
