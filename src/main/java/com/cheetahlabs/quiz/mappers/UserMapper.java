package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.User;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
    @Override
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return User.builder()
                .id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getInt("id") : null)
                .name(ColumnFinder.findColumn("name", resultSet) ? resultSet.getString("name") : null)
                .build();
    }
}
