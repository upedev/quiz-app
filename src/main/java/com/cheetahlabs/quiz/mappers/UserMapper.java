package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
    @Override
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new User(resultSet.getInt("id"),
                resultSet.getString("name"));
    }
}
