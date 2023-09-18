import java.sql.DriverManager;
import java.sql.*;

public class Koneksi extends DatabaseManager{
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/java_perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
