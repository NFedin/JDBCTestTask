package com.test.jdbc.repository;

import com.test.jdbc.config.DBConfig;
import com.test.jdbc.entity.UserEntity;

import java.sql.SQLException;

import static com.test.jdbc.config.DBConfig.resultSet;
import static com.test.jdbc.config.DBConfig.statement;


public class UserRepository implements IRepository {
    public UserEntity findByLogin(String userName) throws SQLException, ClassNotFoundException {
        DBConfig.connectionDB();

        if (userName != null) {
            String sql = "SELECT * FROM users WHERE login = \"" + userName + "\"";

            UserEntity userEntity = null;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                userEntity = UserEntity.builder()
                        .login(resultSet.getString("login"))
                        .firstName(resultSet.getString("first_name"))
                        .secondName(resultSet.getString("second_name"))
                        .middleName( resultSet.getString("middle_name"))
                        .age(resultSet.getInt("age"))
                        .email(resultSet.getString("email"))
                        .phoneNumber(resultSet.getString("phone_number"))
                        .build();
            }
            return userEntity;
        } else {
            return null;
        }
    }

    public boolean updateSecondName(String userName, String change) throws SQLException, ClassNotFoundException {
        System.out.println("\n=====================\n");
        DBConfig.connectionDB();

        if (userName != null) {
            String sql = "UPDATE users SET second_name=\"" + change + "\" WHERE login=\"" + userName + "\"";
            statement.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }
}

