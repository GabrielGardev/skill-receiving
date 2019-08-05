import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class P03_Get_Minion_Names {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement villainStatement =
                connection.prepareStatement("SELECT `name` FROM villains WHERE id = ?");

        System.out.println("Please insert villain ID: ");
        String id = reader.readLine();
        villainStatement.setString(1, id);

        ResultSet resultVillain = villainStatement.executeQuery();

        if (resultVillain.next()) {
            System.out.println(String.format("Villain: %s", resultVillain.getString("name")));
            resultVillain.close();

            PreparedStatement minionStatement =
                    connection.prepareStatement("SELECT `name`, age FROM minions JOIN minions_villains mv on minions.id = mv.minion_id WHERE mv.villain_id = ?");
            minionStatement.setString(1, id);
            ResultSet resultMinion = minionStatement.executeQuery();

            int i = 1;
            while (resultMinion.next()) {
                System.out.println(String.format("%d. %s %s", i,
                        resultMinion.getString("name"),
                        resultMinion.getString("age")));
                i++;
            }

        } else {
            System.out.println(String.format("No villain with ID %s exists in the database.", id));
        }
    }
}
