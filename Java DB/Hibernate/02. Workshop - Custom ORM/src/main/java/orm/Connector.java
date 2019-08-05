package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    public static Connection createConnection(String username, String password, String dbName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, properties);
    }
}
