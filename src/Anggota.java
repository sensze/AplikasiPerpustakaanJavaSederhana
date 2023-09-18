import java.sql.*;

public class Anggota {
    private int id_anggota;
    private String nama_anggota;
    private String no_anggota;
    private Timestamp created_at;

    private DatabaseManager dbManager = new Koneksi();

    public void getAllAnggota(){
        String sql = "SELECT * FROM tb_anggota";
        try{
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                id_anggota = resultSet.getInt("id_anggota");
                nama_anggota = resultSet.getString("nama_anggota");
                no_anggota = resultSet.getString("no_anggota");
                created_at = resultSet.getTimestamp("created_at");

                System.out.println("Id anggota: " + id_anggota);
                System.out.println("Nama anggota: " + nama_anggota);
                System.out.println("Nomor anggota: " + no_anggota);
                System.out.println("Anggota sejak: " + created_at);
                System.out.println("====================================");
            }
            dbManager.disconnect();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void getAnggotaById(int id){
        String sql = "SELECT * FROM tb_anggota WHERE id_anggota = '%d'";
        sql = String.format(sql, id);

        try{
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                id_anggota = resultSet.getInt("id_anggota");
                nama_anggota = resultSet.getString("nama_anggota");
                no_anggota = resultSet.getString("no_anggota");
                created_at = resultSet.getTimestamp("created_at");

                System.out.println("Id anggota: " + id_anggota);
                System.out.println("Nama anggota: " + nama_anggota);
                System.out.println("Nomor anggota: " + no_anggota);
                System.out.println("Anggota sejak: " + created_at);
            }
            dbManager.disconnect();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createAnggota(String nama_anggota, String no_anggota) {
        String sql = "INSERT INTO tb_anggota (nama_anggota, no_anggota) VALUES ('%s', '%s')";
        sql = String.format(sql, nama_anggota, no_anggota);

        try {
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Anggota berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAnggota(int id, String nama_anggota, String no_anggota){
        String sql = "UPDATE tb_anggota SET nama_anggota = '%s', no_anggota = '%s' WHERE id_anggota = %d";
        sql = String.format(sql, nama_anggota, no_anggota, id);
        try{
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Data anggota berhasil dirubah!");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteAnggota(int id){
        String sql = "DELETE FROM tb_anggota WHERE id_anggota = '%d'";
        sql = String.format(sql, id);
        try{
            dbManager.connect();
            Connection conn = dbManager.connection;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            dbManager.disconnect();
            System.out.println("Anggota berhasil dihapus!");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
