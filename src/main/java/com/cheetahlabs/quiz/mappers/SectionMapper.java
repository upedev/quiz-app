package com.cheetahlabs.quiz.mappers;

import com.cheetahlabs.quiz.entities.Section;
import com.cheetahlabs.quiz.utils.ColumnFinder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper implements ResultSetMapper<Section> {
    @Override
    public Section map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Section.builder()
                .id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getString("id") : null)
                .name(ColumnFinder.findColumn("name", resultSet) ? resultSet.getString("name") : null)
                .exam_id(ColumnFinder.findColumn("exam_id", resultSet) ? resultSet.getString("exam_id") : null)
                .description(ColumnFinder.findColumn("description", resultSet) ? resultSet.getString("description") : null)
                .build();
    }
}
