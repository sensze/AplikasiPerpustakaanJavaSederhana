import java.sql.*;

public class Peminjaman {
    private int id_peminjaman;
    private Timestamp tanggal_peminjaman;
    Timestamp tanggal_pengembalian = new Timestamp(System.currentTimeMillis());
    private int id_buku;
    private int id_anggota;
    private int status;

    private DatabaseManager dbManager = new Koneksi();


    public void createPeminjaman(int id_buku, int id_anggota) {
        String sql = "INSERT INTO tb_peminjaman (id_buku, id_anggota, status) VALUES ('%d', '%d', 0)";
        sql = String.format(sql, id_buku, id_anggota);
        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Peminjaman berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPengembalian(int id_peminjaman) {
        String sql = "UPDATE tb_peminjaman SET tanggal_pengembalian = ?, status = 1 WHERE id_peminjaman = ?";

        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, tanggal_pengembalian);
            stmt.setInt(2, id_peminjaman);
            stmt.executeUpdate();
            dbManager.disconnect();
            System.out.println("Peminjaman berhasil dikembalikan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllPeminjaman() {
        String sql = "SELECT * FROM tb_peminjaman WHERE status = 0";
        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                id_peminjaman = resultSet.getInt("id_peminjaman");
                tanggal_peminjaman = resultSet.getTimestamp("tanggal_peminjaman");
                tanggal_pengembalian = resultSet.getTimestamp("tanggal_pengembalian");
                id_buku = resultSet.getInt("id_buku");
                id_anggota = resultSet.getInt("id_anggota");
                status = resultSet.getInt("status");
                System.out.println("Id peminjaman: " + id_peminjaman);
                System.out.println("Tanggal peminjaman: " + tanggal_peminjaman);
                if (tanggal_pengembalian == null) {
                    System.out.println("Tanggal pengembalian: -");
                } else {
                    System.out.println("Tanggal pengembalian: " + tanggal_pengembalian);
                }
                System.out.println("Id buku: " + id_buku);
                System.out.println("Id anggota: " + id_anggota);
                if (status == 0) {
                    System.out.println("Status: Belum Kembali");
                } else {
                    System.out.println("Status: Sudah Kembali");
                }
                System.out.println("====================================");
            }
            dbManager.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllPengembalian() {
        String sql = "SELECT * FROM tb_peminjaman WHERE status = 1";
        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                id_peminjaman = resultSet.getInt("id_peminjaman");
                tanggal_peminjaman = resultSet.getTimestamp("tanggal_peminjaman");
                tanggal_pengembalian = resultSet.getTimestamp("tanggal_pengembalian");
                id_buku = resultSet.getInt("id_buku");
                id_anggota = resultSet.getInt("id_anggota");
                status = resultSet.getInt("status");
                System.out.println("Id peminjaman: " + id_peminjaman);
                System.out.println("Tanggal peminjaman: " + tanggal_peminjaman);
                System.out.println("Tanggal pengembalian: " + tanggal_pengembalian);
                System.out.println("Id buku: " + id_buku);
                System.out.println("Id anggota: " + id_anggota);
                if (status == 0) {
                    System.out.println("Status: Belum Kembali");
                } else {
                    System.out.println("Status: Sudah Kembali");
                }
                System.out.println("====================================");
            }
            dbManager.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
