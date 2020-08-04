package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Test;
import com.cheetahlabs.quiz.models.TestDTO;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import com.fasterxml.jackson.databind.ObjectMapper;
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
                .startTime(ColumnFinder.findColumn("start_time", resultSet) ? resultSet.getTimestamp("start_time") : null)
                .endTime(ColumnFinder.findColumn("end_time", resultSet) ? resultSet.getTimestamp("end_time") : null)
                .dump(ColumnFinder.findColumn("dump", resultSet) ? getDump(resultSet.getString("dump")) : null)
                .build();
    }

    public TestDTO getDump(String dump) {
        ObjectMapper mapper = new ObjectMapper();
        TestDTO testDump = null;
        try {
            testDump = mapper.readValue(dump, TestDTO.class);
        } catch (Exception e) {
        }

        return testDump;
    }
}