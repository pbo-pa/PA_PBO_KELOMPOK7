package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataPasien {
    // Atribut
    private String idPasien;
    private String nama;
    private String noBpjs;
    private String telepon;
    private String statusAntrian;
    private String idPenyakit;

    // Konstruktor
    public DataPasien(String idPasien, String nama, String noBpjs, String telepon, String statusAntrian, String idPenyakit) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.noBpjs = noBpjs;
        this.telepon = telepon;
        this.statusAntrian = statusAntrian;
        this.idPenyakit = idPenyakit;
    }

    // Getter dan Setter
    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoBpjs() {
        return noBpjs;
    }

    public void setNoBpjs(String noBpjs) {
        this.noBpjs = noBpjs;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getStatusAntrian() {
        return statusAntrian;
    }

    public void setStatusAntrian(String statusAntrian) {
        this.statusAntrian = statusAntrian;
    }

    public String getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(String idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    // Metode untuk Menyimpan Data
    public void simpan() {
        String sql = "INSERT INTO data_pasien (id_pasien, nama_pasien, no_bpjs, nomor_telepon, status_antrian, penyakit_id_penyakit) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPasien);
            stmt.setString(2, nama);
            stmt.setString(3, noBpjs);
            stmt.setString(4, telepon);
            stmt.setString(5, statusAntrian);

            // Cek apakah idPenyakit null
            if (idPenyakit == null || idPenyakit.isEmpty()) {
                stmt.setNull(6, java.sql.Types.CHAR);
            } else {
                stmt.setString(6, idPenyakit);
            }

            stmt.executeUpdate();
            System.out.println("Data pasien berhasil disimpan.");
        } catch (SQLException e) {
            System.err.println("Error saat menyimpan data pasien: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // Metode untuk Memperbarui Data
    public void perbarui() {
        String sql = "UPDATE data_pasien SET nama_pasien = ?, nomor_telepon = ?, status_antrian = ? WHERE id_pasien = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setString(2, telepon);
            stmt.setString(3, statusAntrian);
            stmt.setString(4, idPasien);

            stmt.executeUpdate();
            System.out.println("Data pasien berhasil diperbarui.");
        } catch (SQLException e) {
            System.err.println("Error saat memperbarui data pasien: " + e.getMessage());
        }
    }

    // Metode untuk Menghapus Data
    public void hapus() {
        String sql = "DELETE FROM data_pasien WHERE id_pasien = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPasien);

            stmt.executeUpdate();
            System.out.println("Data pasien berhasil dihapus.");
        } catch (SQLException e) {
            System.err.println("Error saat menghapus data pasien: " + e.getMessage());
        }
    }

    // Metode untuk Mengambil Semua Data
    public static List<DataPasien> viewTampilanSemua() throws SQLException {
        List<DataPasien> daftarPasien = new ArrayList<>();
        String sql = "SELECT id_pasien, nama_pasien, no_bpjs, nomor_telepon, status_antrian FROM data_pasien";

        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DataPasien pasien = new DataPasien(
                    rs.getString("id_pasien"),
                    rs.getString("nama_pasien"),
                    rs.getString("no_bpjs"),
                    rs.getString("nomor_telepon"),
                    rs.getString("status_antrian"),
                    null // Tidak mengambil idPenyakit di view
                );
                daftarPasien.add(pasien);
            }
        }

        return daftarPasien;
    }
}
