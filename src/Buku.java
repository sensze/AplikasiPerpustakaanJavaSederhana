import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Buku {
    private int id_buku;
    private String judul_buku;
    private String pengarang_buku;

    private DatabaseManager dbManager = new Koneksi();
    public void getAllBuku() {
        String sql = "SELECT * FROM tb_buku";
        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                id_buku = resultSet.getInt("id_buku");
                judul_buku = resultSet.getString("judul");
                pengarang_buku = resultSet.getString("pengarang");

                System.out.println("ID Buku: " + id_buku);
                System.out.println("Judul Buku: " + judul_buku);
                System.out.println("Pengarang Buku: " + pengarang_buku);
                System.out.println("====================================");
            }
            dbManager.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBukuById(int id) {
        String sql = "SELECT * FROM tb_buku WHERE id_buku = '%d'";
        sql = String.format(sql, id);
        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                id_buku = resultSet.getInt("id_buku");
                judul_buku = resultSet.getString("judul");
                pengarang_buku = resultSet.getString("pengarang");

                System.out.println("ID Buku: " + id_buku);
                System.out.println("Judul Buku: " + judul_buku);
                System.out.println("Pengarang Buku: " + pengarang_buku);
            }
            dbManager.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createBuku(String judul_buku, String pengarang_buku) {
        String sql = "INSERT INTO tb_buku (judul, pengarang) VALUES ('%s', '%s')";
        sql = String.format(sql, judul_buku, pengarang_buku);

        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Buku berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBuku(int id, String judul_buku, String pengarang_buku) {
        String sql = "UPDATE tb_buku SET judul = '%s', pengarang = '%s' WHERE id_buku = %d";
        sql = String.format(sql, judul_buku, pengarang_buku, id);
        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Buku berhasil diubah!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBuku(int id){
        String sql = "DELETE FROM tb_buku WHERE id_buku = '%d'";
        sql = String.format(sql, id);
        try{
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Buku berhasil dihapus!");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}