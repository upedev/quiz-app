package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Test;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMapper implements ResultSetMapper<Test> {
    @Override
    public Test map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Test.builder()
                .id(resultSet.getString("id"))
                .name(resultSet.getString("id"))
                .description(resultSet.getString("id"))
                .duration(resultSet.getString("id"))
                .build();
    }
}