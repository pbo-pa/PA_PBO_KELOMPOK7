/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class KoneksiDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/pa_pbo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getKoneksi() {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi berhasil.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
    public static void closeKoneksi(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Koneksi berhasil ditutup.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

