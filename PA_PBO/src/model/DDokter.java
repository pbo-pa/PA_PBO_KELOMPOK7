package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DDokter {
    private String idDokter;
    private String namaDokter;
    private String spesialisasi;
    private String telepon;
    private String jadwalKerja;
    private String idPelayanan; // Tambahkan idPelayanan

    public DDokter(String idDokter, String namaDokter, String spesialisasi, String telepon, String jadwalKerja, String idPelayanan) {
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.spesialisasi = spesialisasi;
        this.telepon = telepon;
        this.jadwalKerja = jadwalKerja;
        this.idPelayanan = idPelayanan; // Inisialisasi idPelayanan
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJadwalKerja() {
        return jadwalKerja;
    }

    public void setJadwalKerja(String jadwalKerja) {
        this.jadwalKerja = jadwalKerja;
    }

    public String getIdPelayanan() {
        return idPelayanan;
    }

    public void setIdPelayanan(String idPelayanan) {
        this.idPelayanan = idPelayanan;
    }

    

    public void simpan() {
        String sql = "INSERT INTO d_dokter (id_dokter, nama_dokter, spesialisasi, no_telepon, jadwal_kerja, j_pelayanan_id_plyn) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idDokter);
            stmt.setString(2, namaDokter);
            stmt.setString(3, spesialisasi);
            stmt.setString(4, telepon);
            stmt.setString(5, jadwalKerja);
            if (idPelayanan == null || idPelayanan.isEmpty()) {
                stmt.setNull(6, java.sql.Types.VARCHAR); // Secara eksplisit mengatur NULL
            } else {
                stmt.setString(6, idPelayanan);
            }
            stmt.executeUpdate();
            System.out.println("Data dokter berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void perbarui() {
        String sql = "UPDATE d_dokter SET nama_dokter = ?, spesialisasi = ?, no_telepon = ?, jadwal_kerja = ?, j_pelayanan_id_plyn = ? WHERE id_dokter = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaDokter);
            stmt.setString(2, spesialisasi);
            stmt.setString(3, telepon);
            stmt.setString(4, jadwalKerja);
            if (idPelayanan == null || idPelayanan.isEmpty()) {
                stmt.setNull(5, java.sql.Types.VARCHAR); // Secara eksplisit mengatur NULL
            } else {
                stmt.setString(5, idPelayanan);
            }
            stmt.setString(6, idDokter);
            stmt.executeUpdate();
            System.out.println("Data dokter berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void hapus() {
        String sql = "DELETE FROM d_dokter WHERE id_dokter = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idDokter);
            stmt.executeUpdate();
            System.out.println("Data dokter berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<DDokter> viewTampilanSemua() throws SQLException {
        List<DDokter> daftarDokter = new ArrayList<>();
        Connection conn = KoneksiDatabase.getKoneksi();
        String sql = "SELECT d.id_dokter AS idDokter, " +
                     "d.nama_dokter AS namaDokter, " +
                     "d.spesialisasi AS spesialisasi, " +
                     "d.no_telepon AS noTelepon, " +
                     "d.jadwal_kerja AS jadwalKerja, " +
                     "d.j_pelayanan_id_plyn AS idPelayanan " +
                     "FROM d_dokter d";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DDokter dokter = new DDokter(
                    rs.getString("idDokter"),       // id_dokter
                    rs.getString("namaDokter"),     // nama_dokter
                    rs.getString("spesialisasi"),   // spesialisasi
                    rs.getString("noTelepon"),      // no_telepon
                    rs.getString("jadwalKerja"),    // jadwal_kerja
                    rs.getString("idPelayanan")     // j_pelayanan_id_plyn
                );
                daftarDokter.add(dokter);
            }
        }
        return daftarDokter;
    }
}
