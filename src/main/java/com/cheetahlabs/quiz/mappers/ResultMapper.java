package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Result;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMapper implements ResultSetMapper<Result> {

    @Override
    public Result map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Result.builder().id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getInt("id") : null)
                .testId(ColumnFinder.findColumn("test_id", resultSet) ? resultSet.getInt("test_id") : null)
                .userId(ColumnFinder.findColumn("user_id", resultSet) ? resultSet.getInt("user_id") : null)
                .marksObtained(ColumnFinder.findColumn("received_marks", resultSet) ? resultSet.getFloat("received_marks") : null)
                .totalMarks(ColumnFinder.findColumn("total_marks", resultSet) ? resultSet.getFloat("total_marks") : null)
                .build();
    }
}
