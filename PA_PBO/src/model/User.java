package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class User {
    protected String id_akun;
    protected String username;
    protected String password;
    protected String role;


    public User(String id_akun, String username, String password, String role) {
        this.id_akun = id_akun;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public abstract void simpanUser();
    

    public void perbaruiPassword() {
        String sql = "UPDATE user SET password = ? WHERE id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, password);
            stmt.setString(2, id_akun);
            stmt.executeUpdate();
            System.out.println("Password user berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User cariUserBerdasarkanId(String id_akun) {
        String sql = "SELECT * FROM user WHERE id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_akun);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                String username = rs.getString("username");
                String password = rs.getString("password");

                if ("Pasien".equalsIgnoreCase(role)) {
                    return new Pasien(
                        rs.getString("id_akun"),
                        username,
                        password,
                        role
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void hapusUser() {
        String sql = "DELETE FROM user WHERE id_akun = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_akun);
            stmt.executeUpdate();
            System.out.println("Data user berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean registerUser() {
        String insertUserSQL = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(insertUserSQL)) {
            System.out.println("Username di registerUser: " + this.username);
            System.out.println("Password di registerUser: " + this.password);
            System.out.println("Role di registerUser: " + this.role);

            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            stmt.setString(3, this.role);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metode untuk memvalidasi login
    public static User validateLogin(String username, String password, String role) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String id_akun = rs.getString("id_akun");
                if ("Staff".equalsIgnoreCase(role)) {
                    return new Staff(id_akun, username, password, role);
                } else if ("Pasien".equalsIgnoreCase(role)) {
                    return new Pasien(id_akun, username, password, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan koneksi ke database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
