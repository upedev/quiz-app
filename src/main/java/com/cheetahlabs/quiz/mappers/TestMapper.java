package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Test;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMapper implements ResultSetMapper<Test> {
    @Override
    public Test map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Test.builder()
                .id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getString("id") : null)
                .name(ColumnFinder.findColumn("name", resultSet) ? resultSet.getString("name") : null)
                .description(ColumnFinder.findColumn("description", resultSet) ? resultSet.getString("description") : null)
                .duration(ColumnFinder.findColumn("duration", resultSet) ? resultSet.getString("duration") : null)
                .build();
    }
}