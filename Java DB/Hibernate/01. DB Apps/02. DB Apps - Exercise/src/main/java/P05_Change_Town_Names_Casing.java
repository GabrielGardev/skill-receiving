import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class P05_Change_Town_Names_Casing {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();

        String country = reader.readLine();

        if (isCountyExist(country, connection)){
            updateCities(country, connection);

            ArrayList<String> list = updatedCities(country, connection);

            System.out.println(String.format("%d town names were affected.", list.size()));
            String result = String.join(", ", list);
            System.out.println("[" + result + "]");
        }else {
            System.out.println("No town names were affected.");
        }
    }

    private static  ArrayList<String> updatedCities(String country, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name FROM towns\n" +
                "WHERE country = ?");
        ps.setString(1, country);
        ResultSet resultSet = ps.executeQuery();

        ArrayList<String> result = new ArrayList<String>();
        while (resultSet.next()){
           result.add(resultSet.getString("name"));
        }

        return result;
    }

    private static void updateCities(String country, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE towns\n" +
                "SET name = upper(name)\n" +
                "WHERE country = ?");
        ps.setString(1, country);
        ps.executeUpdate();
    }

    private static boolean isCountyExist(String country, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM towns\n" +
                "WHERE country = ?");
        preparedStatement.setString(1, country);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
