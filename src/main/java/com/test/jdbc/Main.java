package com.test.jdbc;

import com.test.jdbc.config.DBConfig;
import com.test.jdbc.entity.UserEntity;
import com.test.jdbc.repository.UserRepository;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            DBConnector.connectDb();
            UserRepository userRepository = new UserRepository();
            UserEntity userEntity = userRepository.findByLogin("Dandy");
            System.out.println(userEntity.toString());

            System.out.println(userRepository.updateSecondName("Puppey", "Ivanov"));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Closing connection and releasing resources...");
            DBConfig.closeDB();
        }
    }
}

