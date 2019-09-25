package com.test.jdbc.config;

import java.sql.*;

public class DBConfig {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/company?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "12345";

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void connectionDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public static void closeDB() throws ClassNotFoundException, SQLException{
        resultSet.close();
        statement.close();
        connection.close();
    }
}
