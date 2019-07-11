package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Question;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements ResultSetMapper<Question> {
    @Override
    public Question map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return null;
    }
}