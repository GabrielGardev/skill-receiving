import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class P04_Add_Minion {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws SQLException, IOException {

        Connection connection = getConnection();

        String[] input = reader.readLine().split(" ");

        String minionName = input[1];
        int age = Integer.parseInt(input[2]);
        String minionTown = input[3];
        String villainName = reader.readLine().split(" ")[1];

        addTownToDB(minionTown, connection);
        addVillainToDB(villainName, connection);
        addMinionToDB(minionName, age, villainName, minionTown, connection);
        addMinionToVillain(minionName, villainName, connection);
    }

    private static void addMinionToVillain(String minionName, String villainName, Connection connection) throws SQLException {
        PreparedStatement minionVillainStatement = connection.prepareStatement("INSERT INTO minions_villains (minion_id, villain_id) \n" +
                "VALUES (?, ?)");
        minionVillainStatement.setInt(1, getMinionId(minionName, connection));
        minionVillainStatement.setInt(2, getVillainId(villainName, connection));
        minionVillainStatement.executeUpdate();

        System.out.println(String.format("Successfully added %s to be minion of %s.", minionName, villainName));
    }

    private static void addMinionToDB(String minionName, int age, String villainName, String townName, Connection connection) throws SQLException {
        PreparedStatement insertMinion = connection.prepareStatement("INSERT INTO minions(name, age, town_id)\n" +
                "VALUES (?, ?, ?);");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, age);
        insertMinion.setInt(3, getTownId(townName, connection));
        insertMinion.executeUpdate();
    }

    private static int getTownId(String townName, Connection connection) throws SQLException {
        PreparedStatement townID = connection.prepareStatement("SELECT id FROM towns\n" +
                "WHERE name = ?");
        townID.setString(1, townName);
        ResultSet resultSet = townID.executeQuery();

        int id = 0;
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return id;
    }

    private static int getVillainId(String villainName, Connection connection) throws SQLException {
        PreparedStatement villainID = connection.prepareStatement("SELECT id FROM villains\n" +
                "WHERE name = ?");
        villainID.setString(1, villainName);
        ResultSet resultSet = villainID.executeQuery();

        int id = 0;
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return id;
    }

    private static int getMinionId(String minionName, Connection connection) throws SQLException {
        PreparedStatement minionID = connection.prepareStatement("SELECT id FROM minions\n" +
                "WHERE name = ?");
        minionID.setString(1, minionName);
        ResultSet resultSet = minionID.executeQuery();

        int id = 0;
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return id;
    }

    private static void addVillainToDB(String villainName, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT `name` FROM villains WHERE name = ?");
        ps.setString(1, villainName);

        ResultSet resultSet = ps.executeQuery();

        if (!resultSet.next()){
            PreparedStatement insertVillain = connection.prepareStatement("INSERT INTO villains(name, evilness_factor)\n" +
                    "VALUES (?, 'evil');");
            insertVillain.setString(1, villainName);
            insertVillain.executeUpdate();

            System.out.println(String.format("Villain %s was added to the database.", villainName));
        }
    }

    private static void addTownToDB(String minionTown, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT `name` FROM towns WHERE name = ?");
        ps.setString(1, minionTown);

        ResultSet resultSet = ps.executeQuery();

        if (!resultSet.next()){
            PreparedStatement insertTown = connection.prepareStatement("INSERT INTO towns(name, country)\n" +
                    "VALUES (?, 'BG');");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            System.out.println(String.format("Town %s was added to the database.", minionTown));
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

      return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }

}
