import java.sql.Connection;

public abstract class DatabaseManager {
    protected Connection connection;

    public abstract void connect();

    public abstract void disconnect();
}