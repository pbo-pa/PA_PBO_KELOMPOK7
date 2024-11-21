/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Staff extends User {
    private String jabatan;

    public Staff(String id_akun, String username, String password, String role) {
        super(id_akun, username, password, role);
        this.jabatan = jabatan;
    }

    @Override
    public void simpanUser() {
        String userSql = "INSERT INTO user (id_akun, username, password, role) VALUES (?, ?, ?, ?)";
        String staffSql = "INSERT INTO staff (id_akun, jabatan) VALUES (?, ?)";

        try (Connection conn = KoneksiDatabase.getKoneksi()) {
            try (PreparedStatement stmt = conn.prepareStatement(userSql)) {
                stmt.setString(1, id_akun);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.setString(4, role);
                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(staffSql)) {
                stmt.setString(1, id_akun);
                stmt.setString(2, jabatan);
                stmt.executeUpdate();
            }

            System.out.println("Data staff berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void perbaruiJabatan() {
        String sql = "UPDATE staff SET jabatan = ? WHERE id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jabatan);
            stmt.setString(2, id_akun);
            stmt.executeUpdate();
            System.out.println("Jabatan staff berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Staff cariStaffBerdasarkanId(String id_akun) {
        String sql = "SELECT * FROM user JOIN staff ON user.id_akun = staff.id_akun WHERE user.id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_akun);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Staff(
                    rs.getString("id_akun"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void hapusStaff() {
        hapusUser();
        String sql = "DELETE FROM staff WHERE id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_akun);
            stmt.executeUpdate();
            System.out.println("Data staff berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
