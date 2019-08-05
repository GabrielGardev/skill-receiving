import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class P07_Print_All_Minion_Names {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();

        List<String> names = getMinionNames(connection);

        int n = 0;
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 == 0){
                System.out.println(names.get(n));
                n++;
            }else {
                System.out.println(names.get(names.size() - n));
            }
        }

    }

    private static List<String> getMinionNames(Connection connection) throws SQLException {
        List<String> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT name FROM minions");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
            result.add(resultSet.getString("name"));
        }

        return result;
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
