package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Exam;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamMapper implements ResultSetMapper<Exam> {
    @Override
    public Exam map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Exam.builder()
                .id(resultSet.getString("id"))
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .build();
    }
}
