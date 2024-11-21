package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JPelayanan {
    private String id_plyn;
    private String jenis_pelayanan;
    private String waktu_pelayanan;
    private String tanggal_pelayanan;
    private String status_pelayanan;

    // Constructor
    public JPelayanan(String id_plyn, String jenis_pelayanan, String waktu_pelayanan, String tanggal_pelayanan, String status_pelayanan) {
        this.id_plyn = id_plyn;
        this.jenis_pelayanan = jenis_pelayanan;
        this.waktu_pelayanan = waktu_pelayanan;
        this.tanggal_pelayanan = tanggal_pelayanan;
        this.status_pelayanan = status_pelayanan;
    }

    // Getter dan Setter
    public String getId_plyn() {
        return id_plyn;
    }

    public void setId_plyn(String id_plyn) {
        this.id_plyn = id_plyn;
    }

    public String getJenis_pelayanan() {
        return jenis_pelayanan;
    }

    public void setJenis_pelayanan(String jenis_pelayanan) {
        this.jenis_pelayanan = jenis_pelayanan;
    }

    public String getWaktu_pelayanan() {
        return waktu_pelayanan;
    }

    public void setWaktu_pelayanan(String waktu_pelayanan) {
        this.waktu_pelayanan = waktu_pelayanan;
    }

    public String getTanggal_pelayanan() {
        return tanggal_pelayanan;
    }

    public void setTanggal_pelayanan(String tanggal_pelayanan) {
        this.tanggal_pelayanan = tanggal_pelayanan;
    }

    public String getStatus_pelayanan() {
        return status_pelayanan;
    }

    public void setStatus_pelayanan(String status_pelayanan) {
        this.status_pelayanan = status_pelayanan;
    }

    // Simpan Data Pelayanan
    public void simpanPelayanan() {
        String sql = "INSERT INTO j_pelayanan (id_plyn, jenis_pelayanan, waktu_pelayanan, tanggal_pelayanan, status_pelayanan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_plyn); // ID Pelayanan
            stmt.setString(2, jenis_pelayanan); // Jenis Pelayanan
            stmt.setString(3, waktu_pelayanan); // Waktu Pelayanan
            stmt.setString(4, tanggal_pelayanan); // Tanggal Pelayanan
            stmt.setString(5, status_pelayanan); // Status Pelayanan

            stmt.executeUpdate();
            System.out.println("Data pelayanan berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Gagal menyimpan data pelayanan: " + e.getMessage());
        }
    }

    // Update Status Pelayanan
    public void perbaruiStatusPelayanan() {
        String sql = "UPDATE j_pelayanan SET jenis_pelayanan = ?, waktu_pelayanan = ?, tanggal_pelayanan = ?, status_pelayanan = ? WHERE id_plyn = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jenis_pelayanan); // Jenis Pelayanan
            stmt.setString(2, waktu_pelayanan); // Waktu Pelayanan
            stmt.setString(3, tanggal_pelayanan); // Tanggal Pelayanan
            stmt.setString(4, status_pelayanan); // Status Pelayanan
            stmt.setString(5, id_plyn); // ID Pelayanan

            stmt.executeUpdate();
            System.out.println("Data pelayanan berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Gagal memperbarui data pelayanan: " + e.getMessage());
        }
    }

    // Cari Pelayanan Berdasarkan ID
    public static JPelayanan cariPelayananBerdasarkanId(String id_plyn) {
        String sql = "SELECT * FROM j_pelayanan WHERE id_plyn = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_plyn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new JPelayanan(
                    rs.getString("id_plyn"),
                    rs.getString("jenis_pelayanan"),
                    rs.getString("waktu_pelayanan"),
                    rs.getString("tanggal_pelayanan"),
                    rs.getString("status_pelayanan")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Gagal mencari data pelayanan: " + e.getMessage());
        }
        return null;
    }

    // Hapus Data Pelayanan
    public void hapusPelayanan() {
        String sql = "DELETE FROM j_pelayanan WHERE id_plyn = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_plyn); // ID Pelayanan
            stmt.executeUpdate();
            System.out.println("Data pelayanan berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Gagal menghapus data pelayanan: " + e.getMessage());
        }
    }

    // Lihat Semua Data Pelayanan
    public static List<JPelayanan> viewTampilanSemua() throws SQLException {
        List<JPelayanan> daftarPelayanan = new ArrayList<>();
        Connection conn = KoneksiDatabase.getKoneksi();

        String sql = "SELECT id_plyn, jenis_pelayanan, waktu_pelayanan, tanggal_pelayanan, status_pelayanan FROM j_pelayanan";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                JPelayanan data = new JPelayanan(
                    rs.getString("id_plyn"),
                    rs.getString("jenis_pelayanan"),
                    rs.getString("waktu_pelayanan"),
                    rs.getString("tanggal_pelayanan"),
                    rs.getString("status_pelayanan")
                );
                daftarPelayanan.add(data);
            }
        } catch (SQLException e) {
            System.err.println("Kesalahan saat mengambil data pelayanan: " + e.getMessage());
            throw e;
        }
        return daftarPelayanan;
    }
}
