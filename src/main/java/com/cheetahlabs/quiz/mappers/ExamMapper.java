package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Exam;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamMapper implements ResultSetMapper<Exam> {
    @Override
    public Exam map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Exam.builder()
                .id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getString("id") : null)
                .name(ColumnFinder.findColumn("name", resultSet) ? resultSet.getString("name") : null)
                .description(ColumnFinder.findColumn("description", resultSet) ? resultSet.getString("description") : null)
                .build();
    }
}
