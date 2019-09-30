package com.test.jdbc.config;

import java.sql.*;

public class DBConnector {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/company?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "12345";

    public static Connection connection;
    public static Statement statement;

    public static void connectDB() {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public static Statement getStatementDB() throws ClassNotFoundException, SQLException {
       	return statement;
    }

    public static void closeDB() throws ClassNotFoundException, SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
