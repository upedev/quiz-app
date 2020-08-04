package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Question;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements ResultSetMapper<Question> {
    @Override
    public Question map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Question.builder()
                .id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getString("id") : null)
                .text(ColumnFinder.findColumn("text", resultSet) ? resultSet.getString("text") : null)
                .section_id(ColumnFinder.findColumn("section_id", resultSet) ? resultSet.getString("section_id") : null)
                .exam_id(ColumnFinder.findColumn("exam_id", resultSet) ? resultSet.getString("exam_id") : null)
                .test_id(ColumnFinder.findColumn("test_id", resultSet) ? resultSet.getString("test_id") : null)
                .image_url(ColumnFinder.findColumn("image_url", resultSet) ? resultSet.getString("image_url") : null)
                .build();
    }
}