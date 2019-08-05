import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class P09_Increase_Age_Stored_Procedure {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection connection = getConnection();

        int minionId = Integer.parseInt(reader.readLine());

        callProcedure(connection, minionId);
        printMinion(connection, minionId);

    }

    private static void printMinion(Connection connection, int minionId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        ps.setInt(1, minionId);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            System.out.println(String.format("%s %d",
                    resultSet.getString("name"),
                    resultSet.getInt("age")));
        }
    }

    private static void callProcedure(Connection connection, int minionId) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call usp_get_older(?)}");
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
