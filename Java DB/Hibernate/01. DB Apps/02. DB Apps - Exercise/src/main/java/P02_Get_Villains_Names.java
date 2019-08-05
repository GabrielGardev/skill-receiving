import java.sql.*;
import java.util.Properties;

public class P02_Get_Villains_Names {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Statement stmt;
        String query = "SELECT v.`name`, COUNT(mv.minion_id) as 'count'\n" +
                        "FROM villains as v\n" +
                        "JOIN minions_villains as mv\n" +
                        "ON v.id = mv.villain_id\n" +
                        "GROUP BY v.`name`\n" +
                        "HAVING `count` > 15\n" +
                        "ORDER BY `count` DESC";

        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()){
            System.out.println(String.format("%s %s",
                    rs.getString("name"),
                    rs.getString("count")));
        }
    }
}
