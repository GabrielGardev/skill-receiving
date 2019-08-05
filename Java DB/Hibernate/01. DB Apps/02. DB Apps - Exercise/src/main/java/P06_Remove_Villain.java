import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class P06_Remove_Villain {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();

        int villainID = Integer.parseInt(reader.readLine());
        if (isVillainExist(villainID, connection)) {
            int count = getMinionsCount(villainID, connection);

            releaseMinions(villainID, connection);
            String name = deleteVillain(villainID, connection);

            System.out.println(String.format("%s was deleted", name));
            System.out.printf("%d minions released", count);
        }else {
            System.out.println("No such villain was found");
        }
    }

    private static boolean isVillainExist(int villainID, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM villains WHERE id = ?");
        ps.setInt(1, villainID);

        return ps.executeQuery().next();
    }

    private static void releaseMinions(int villainID, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM minions_villains\n" +
                "WHERE villain_id = ?");
        ps.setInt(1, villainID);
        ps.executeUpdate();
    }

    private static String deleteVillain(int villainID, Connection connection) throws SQLException {
        PreparedStatement getName = connection.prepareStatement("SELECT name FROM villains\n" +
                "WHERE id = ?");
        getName.setInt(1, villainID);
        ResultSet resultSet = getName.executeQuery();
        resultSet.next();

        PreparedStatement ps = connection.prepareStatement("DELETE FROM villains\n" +
                "WHERE id = ?");
        ps.setInt(1, villainID);
        ps.executeUpdate();

        return resultSet.getString("name");
    }

    private static int getMinionsCount(int villainID, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT COUNT(minion_id) as 'count' FROM minions_villains\n" +
                "WHERE villain_id = ?");
        ps.setInt(1, villainID);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        return resultSet.getInt("count");
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
