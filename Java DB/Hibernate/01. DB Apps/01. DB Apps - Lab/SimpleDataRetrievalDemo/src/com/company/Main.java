package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = sc.nextLine().trim();
        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT u.user_name,u.first_name, u.last_name, COUNT(ug.id) AS `count` FROM users AS u\n" +
                        "JOIN users_games AS ug\n" +
                        "ON u.id = ug.user_id\n" +
                        "WHERE u.user_name = ?");

        String username = sc.nextLine();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            if (rs.getString("user_name") == null){
                System.out.println("No such user exists");
                break;
            }

            System.out.println(String.format("User: %s", rs.getString("user_name")));
            System.out.println(String.format("%s %s has played %d games", rs.getString("first_name"),
                    rs.getString("last_name"), rs.getInt("count")));
        }
        connection.close();
    }
}