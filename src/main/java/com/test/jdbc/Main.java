package com.test.jdbc;

import java.sql.*;

public class Main {
    /**
     * JDBC Driver and database url
     */

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/company?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "12345";

    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    static String sql = null;

    public static void main(String[] args) throws SQLException {
        try {
            System.out.println(findByLogin("Dandy"));
            System.out.println(updateSecondName("Puppey", "Ivanov"));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Closing connection and releasing resources...");
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

    public static void connectionDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public static boolean findByLogin(String userName) throws SQLException, ClassNotFoundException {
        connectionDB();

        if (userName != null) {
            sql = "SELECT * FROM users WHERE login = \"" + userName + "\"";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("\n================\n");
                System.out.println("login: " + resultSet.getString("login"));
                System.out.println("firstName: " + resultSet.getString("first_name"));
                System.out.println("secondName: " + resultSet.getString("second_name"));
                System.out.println("middleName: " + resultSet.getString("middle_name"));
                System.out.println("age: " + resultSet.getInt("age"));
                System.out.println("email: " + resultSet.getString("email"));
                System.out.println("phoneNumber: " + resultSet.getString("phone_number"));
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean updateSecondName(String userName, String change) throws SQLException, ClassNotFoundException {
        System.out.println("\n=====================\n");
        connectionDB();

        if (userName != null) {
            sql = "UPDATE users SET second_name=\"" + change + "\" WHERE login=\"" + userName + "\"";
            statement.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }
}

