package com.test.jdbc.repository;

import com.test.jdbc.entity.UserEntity;

import java.sql.SQLException;

public interface IRepository {

    UserEntity findByLogin(String userName) throws SQLException, ClassNotFoundException ;
    boolean updateSecondName(String userName, String change) throws SQLException, ClassNotFoundException ;
}
