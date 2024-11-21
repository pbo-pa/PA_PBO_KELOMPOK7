/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Antrian {
    private String idAntrian;
    private String waktuMasuk;
    private String status;
    private String idPelayanan;
    private String idPasien;

    public Antrian(String idAntrian, String waktuMasuk, String status, String idPelayanan, String idPasien) {
        this.idAntrian = idAntrian;
        this.waktuMasuk = waktuMasuk;
        this.status = status;
        this.idPelayanan = idPelayanan;
        this.idPasien = idPasien;
    }

    public String getIdAntrian() {
        return idAntrian;
    }

    public void setIdAntrian(String idAntrian) {
        this.idAntrian = idAntrian;
    }

    public String getWaktuMasuk() {
        return waktuMasuk;
    }

    public void setWaktuMasuk(String waktuMasuk) {
        this.waktuMasuk = waktuMasuk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdPelayanan() {
        return idPelayanan;
    }

    public void setIdPelayanan(String idPelayanan) {
        this.idPelayanan = idPelayanan;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }
    
    

    // Simpan data antrian
    public void simpan() {
        String sql = "INSERT INTO antrian (id_antrian, waktu_masuk_antrian, status_antrian, j_pelayanan_id_plyn, data_pasien_id_pasien) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idAntrian);
            stmt.setString(2, waktuMasuk);
            stmt.setString(3, status);
            stmt.setString(4, idPelayanan);
            stmt.setString(5, idPasien);
            stmt.executeUpdate();
            System.out.println("Data antrian berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Perbarui data antrian
    public void perbarui() {
        String sql = "UPDATE antrian SET status_antrian = ? WHERE id_antrian = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setString(2, idAntrian);
            stmt.executeUpdate();
            System.out.println("Data antrian berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cari antrian berdasarkan ID antrian
    public static Antrian cariBerdasarkanId(String id) {
        String sql = "SELECT * FROM antrian WHERE id_antrian = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Antrian(
                    rs.getString("id_antrian"),
                    rs.getString("waktu_masuk_antrian"),
                    rs.getString("status_antrian"),
                    rs.getString("j_pelayanan_id_plyn"),
                    rs.getString("data_pasien_id_pasien")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cari antrian berdasarkan Nama Pasien
    public static List<Antrian> cariByNama(String namaPasien) {
        List<Antrian> antrianList = new ArrayList<>();
        String sql = "SELECT a.id_antrian, a.waktu_masuk_antrian, a.status_antrian, a.j_pelayanan_id_plyn, a.data_pasien_id_pasien " +
                     "FROM antrian a JOIN data_pasien dp ON a.data_pasien_id_pasien = dp.id_pasien " +
                     "WHERE dp.nama_pasien LIKE ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + namaPasien + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                antrianList.add(new Antrian(
                    rs.getString("id_antrian"),
                    rs.getString("waktu_masuk_antrian"),
                    rs.getString("status_antrian"),
                    rs.getString("j_pelayanan_id_plyn"),
                    rs.getString("data_pasien_id_pasien")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antrianList;
    }

    // Hapus data antrian
    public void hapus() {
        String sql = "DELETE FROM antrian WHERE id_antrian = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idAntrian);
            stmt.executeUpdate();
            System.out.println("Data antrian berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<Antrian> cariById(String idPasien) throws SQLException {
        List<Antrian> daftarAntrian = new ArrayList<>();
        Connection conn = KoneksiDatabase.getKoneksi();
        String sql = "SELECT a.id_antrian AS idAntrian, " +
                     "a.waktu_masuk_antrian AS waktuMasuk, " +
                     "a.status_antrian AS status, " +
                     "p.id_pasien AS idPasien, " +
                     "p.nama_pasien AS namaPasien " +
                     "FROM antrian a " +
                     "JOIN data_pasien p ON a.data_pasien_id_pasien = p.id_pasien " +
                     "WHERE p.id_pasien = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPasien);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Antrian data = new Antrian(
                    rs.getString("idAntrian"),       // id_antrian
                    rs.getString("waktuMasuk"),     // waktu_masuk_antrian
                    rs.getString("status"),         // status_antrian
                    rs.getString("idPasien"),       // id_pasien
                    rs.getString("namaPasien")      // nama_pasien
                );
                daftarAntrian.add(data);
            }
        }
        return daftarAntrian;
    }
    
    
    
    public static List<Antrian> viewTampilanSemua() throws SQLException {
        List<Antrian> daftarAntrian = new ArrayList<>();
        String sql = "SELECT a.id_antrian AS idAntrian, " +
                     "a.waktu_masuk_antrian AS waktuMasuk, " +
                     "a.status_antrian AS status, " +
                     "a.j_pelayanan_id_plyn AS idPelayanan, " +
                     "p.id_pasien AS idPasien, " +
                     "p.nama_pasien AS namaPasien " +
                     "FROM antrian a " +
                     "JOIN data_pasien p ON a.data_pasien_id_pasien = p.id_pasien";

        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Antrian data = new Antrian(
                    rs.getString("idAntrian"),      // id_antrian
                    rs.getString("waktuMasuk"),    // waktu_masuk_antrian
                    rs.getString("status"),        // status_antrian
                    rs.getString("idPelayanan"),   // j_pelayanan_id_plyn
                    rs.getString("idPasien")       // id_pasien
                );
                daftarAntrian.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Gagal mengambil data antrian: " + e.getMessage());
        }

        return daftarAntrian;
    }







}
