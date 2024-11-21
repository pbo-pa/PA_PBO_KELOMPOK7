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

public class Penyakit {
    private String id_penyakit;
    private String nama_penyakit;
    private String kategori_urgensi;

    public Penyakit(String id_penyakit, String nama_penyakit, String kategori_urgensi) {
        this.id_penyakit = id_penyakit;
        this.nama_penyakit = nama_penyakit;
        this.kategori_urgensi = kategori_urgensi;
    }

    public String getId_penyakit() {
        return id_penyakit;
    }

    public void setId_penyakit(String id_penyakit) {
        this.id_penyakit = id_penyakit;
    }

    public String getNama_penyakit() {
        return nama_penyakit;
    }

    public void setNama_penyakit(String nama_penyakit) {
        this.nama_penyakit = nama_penyakit;
    }

    public String getKategori_urgensi() {
        return kategori_urgensi;
    }

    public void setKategori_urgensi(String kategori_urgensi) {
        this.kategori_urgensi = kategori_urgensi;
    }
    
    

    public void simpanPenyakit() {
        String sql = "INSERT INTO penyakit (id_penyakit, nama_penyakit, kategori_urgensi) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_penyakit);
            stmt.setString(2, nama_penyakit);
            stmt.setString(3, kategori_urgensi);
            stmt.executeUpdate();
            System.out.println("Data penyakit berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void perbaruiKategoriUrgensi() {
        String sql = "UPDATE penyakit SET kategori_urgensi = ? WHERE id_penyakit = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, kategori_urgensi);
            stmt.setString(2, id_penyakit);
            stmt.executeUpdate();
            System.out.println("Kategori urgensi penyakit berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Penyakit cariPenyakitBerdasarkanId(String id_penyakit) {
        String sql = "SELECT * FROM penyakit WHERE id_penyakit = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_penyakit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Penyakit(
                    rs.getString("id_penyakit"),
                    rs.getString("nama_penyakit"),
                    rs.getString("kategori_urgensi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void hapusPenyakit() {
        String sql = "DELETE FROM penyakit WHERE id_penyakit = ?";
        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_penyakit);
            stmt.executeUpdate();
            System.out.println("Data penyakit berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Penyakit> getPenyakitByKategoriPenyakit(String kategoriPenyakit) throws SQLException {
        List<Penyakit> daftarPenyakit = new ArrayList<>();
        String sql = "SELECT dp.nama_pasien, p.id_penyakit, p.nama_penyakit, p.kategori_urgensi " +
                     "FROM data_pasien dp " +
                     "JOIN penyakit p ON dp.PENYAKIT_id_penyakit = p.id_penyakit " +
                     "WHERE p.kategori_urgensi = ?";

        try (Connection conn = KoneksiDatabase.getKoneksi(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameter kategori penyakit
            stmt.setString(1, kategoriPenyakit);

            // Eksekusi query
            ResultSet rs = stmt.executeQuery();

            // Iterasi hasil query
            while (rs.next()) {
                Penyakit penyakit = new Penyakit(
                        rs.getString("id_penyakit"),       // ID Penyakit
                        rs.getString("nama_penyakit"),    // Nama Penyakit
                        rs.getString("kategori_urgensi")// Kategori Penyakit
//                        rs.getString("nama_pasien")       // Nama Pasien
                );
                daftarPenyakit.add(penyakit);
            }
        }

        return daftarPenyakit;
    }
    
    public static List<Penyakit> viewTampilanSemua() throws SQLException {
        List<Penyakit> daftarPenyakit = new ArrayList<>();
        Connection conn = KoneksiDatabase.getKoneksi();
        String sql = "SELECT p.id_penyakit AS idPenyakit, " +
                     "p.nama_penyakit AS namaPenyakit, " +
                     "p.kategori_urgensi AS kategori_urgensi, " +
                     "dp.nama_pasien AS namaPasien " +
                     "FROM penyakit p " +
                     "JOIN data_pasien dp ON dp.PENYAKIT_id_penyakit = p.id_penyakit";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Penyakit data = new Penyakit(
                    rs.getString("idPenyakit"),       // ID Penyakit
                    rs.getString("namaPenyakit"),    // Nama Penyakit
                        rs.getString("kategori_urgensi")// Kategori Penyakit
//                    rs.getString("namaPasien")       // Nama Pasien
                );
                daftarPenyakit.add(data);
            }
        } catch (SQLException e) {
            System.err.println("Kesalahan saat mengambil data penyakit: " + e.getMessage());
            e.printStackTrace();
        }
        return daftarPenyakit;
    }
}
