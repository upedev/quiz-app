package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Section;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper implements ResultSetMapper<Section> {
    @Override
    public Section map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Section.builder()
                .id(resultSet.getString("id"))
                .name(resultSet.getString("name"))
                .exam_id(resultSet.getString("exam_id"))
                .description(resultSet.getString("description"))
                .build();
    }
}
