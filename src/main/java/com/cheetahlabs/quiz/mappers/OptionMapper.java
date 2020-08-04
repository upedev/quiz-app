package com.cheetahlabs.quiz.mappers;

        import com.cheetahlabs.quiz.entities.Options;
        import com.cheetahlabs.quiz.utils.ColumnFinder;
        import org.skife.jdbi.v2.StatementContext;
        import org.skife.jdbi.v2.tweak.ResultSetMapper;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class OptionMapper implements ResultSetMapper<Options> {

    @Override
    public Options map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Options.builder()
                .id(ColumnFinder.findColumn("id", resultSet) ? resultSet.getInt("id") : null)
                .text(ColumnFinder.findColumn("text", resultSet) ? resultSet.getString("text") : null)
                .questionId(ColumnFinder.findColumn("question_id", resultSet) ? resultSet.getString("question_id") : null)
                .isAnswer(ColumnFinder.findColumn("is_answer", resultSet) ? resultSet.getBoolean("is_answer") : null)
                .build();

    }
}