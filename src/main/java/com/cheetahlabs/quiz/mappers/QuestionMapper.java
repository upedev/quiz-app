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
                .section_id(ColumnFinder.findColumn("section_id", resultSet) ? resultSet.getString("section_id") : null)
                .exam_id(ColumnFinder.findColumn("exam_id", resultSet) ? resultSet.getString("exam_id") : null)
                .test_id(ColumnFinder.findColumn("test_id", resultSet) ? resultSet.getString("test_id") : null)
                .description(ColumnFinder.findColumn("description", resultSet) ? resultSet.getString("description") : null)
                .image_url(ColumnFinder.findColumn("image_url", resultSet) ? resultSet.getString("image_url") : null)
                .option1(ColumnFinder.findColumn("option1", resultSet) ? resultSet.getString("option1") : null)
                .option2(ColumnFinder.findColumn("option2", resultSet) ? resultSet.getString("option2") : null)
                .option3(ColumnFinder.findColumn("option3", resultSet) ? resultSet.getString("option3") : null)
                .option4(ColumnFinder.findColumn("option4", resultSet) ? resultSet.getString("option4") : null)
                .is_option_1(ColumnFinder.findColumn("is_option_1", resultSet) ? resultSet.getString("is_option_1") : null)
                .is_option_2(ColumnFinder.findColumn("is_option_2", resultSet) ? resultSet.getString("is_option_2") : null)
                .is_option_3(ColumnFinder.findColumn("is_option_3", resultSet) ? resultSet.getString("is_option_3") : null)
                .is_option_4(ColumnFinder.findColumn("is_option_4", resultSet) ? resultSet.getString("is_option_4") : null)
                .build();
    }
}