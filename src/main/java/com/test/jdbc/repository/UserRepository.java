package com.test.jdbc.repository;

import com.test.jdbc.config.DBConfig;
import com.test.jdbc.entity.UserEntity;

import java.sql.SQLException;

public class UserRepository implements IRepository {

    public UserEntity findByLogin(String userName) throws SQLException, ClassNotFoundException, NullPointerException {
        Statement statement = DBConnector.getStatementDB();
        if(statement == null) {
            throw new NullPointerException("Cannot connect to database");
        }
        UserEntity userEntity = null;
        if (userName != null) {
            String sql = "SELECT * FROM users WHERE login = \"" + userName + "\"";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // TODO: у тебя же уникальныое имя, это, наверно, можно убрать
                userEntity = UserEntity.builder()
                        .login(resultSet.getString("login"))
                        .firstName(resultSet.getString("first_name"))
                        .secondName(resultSet.getString("second_name"))
                        .middleName(resultSet.getString("middle_name"))
                        .age(resultSet.getInt("age"))
                        .email(resultSet.getString("email"))
                        .phoneNumber(resultSet.getString("phone_number"))
                        .build();
            }
        }

        return userEntity;
    }

    public boolean updateSecondName(String userName, String change) throws SQLException, ClassNotFoundException, NullPointerException {
        System.out.println("\n=====================\n");
        Statement statement = DBConnector.getStatementDB();
        if(statement == null) {
              throw new NullPointerException("Cannot connect to database");
        }
        if (statement != null && userName != null) {
            String sql = "UPDATE users SET second_name=\"" + change + "\" WHERE login=\"" + userName + "\"";
            statement.executeUpdate(sql);
            return true;
        } 
        return false;
    }
}

