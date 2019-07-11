package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Question;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements ResultSetMapper<Question> {
    @Override
    public Question map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Question.builder()
                .id(resultSet.getString("id"))
                .section_id(resultSet.getString("section_id"))
                .exam_id(resultSet.getString("exam_id"))
                .test_id(resultSet.getString("test_id"))
                .description(resultSet.getString("description"))
                .image_url(resultSet.getString("image_url"))
                .option1(resultSet.getString("option1"))
                .option2(resultSet.getString("option2"))
                .option3(resultSet.getString("option3"))
                .option4(resultSet.getString("option4"))
                .is_option_1(resultSet.getString("is_option_1"))
                .is_option_2(resultSet.getString("is_option_2"))
                .is_option_3(resultSet.getString("is_option_3"))
                .is_option_4(resultSet.getString("is_option_4"))
                .build();
    }
}