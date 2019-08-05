import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class P08_Increase_Minions_Age {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connection connection = getConnection();

        int[] minionsIDs = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        updateMinions(minionsIDs, connection);
        printMinions(connection);
    }

    private static void printMinions(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
            System.out.println(String.format("%s %d",
                    resultSet.getString("name"),
                    resultSet.getInt("age")));
        }
    }

    private static void updateMinions(int[] minionsIDs, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE minions\n" +
                "SET age = age + 1,\n" +
                "    name = lower(name)\n" +
                "WHERE id = ?");

        for (int minionsID : minionsIDs) {
            ps.setInt(1, minionsID);
            ps.executeUpdate();
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
