package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.entities.Options;
import com.cheetahlabs.quiz.mappers.OptionMapper;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import java.util.List;

@RegisterMapper(OptionMapper.class)
@UseStringTemplate3StatementLocator
public interface OptionsDao {

    @SqlQuery("SELECT * FROM options WHERE question_id IN (<questionList>) and `is_answer` = \"true\"")
    List<Options> getCorrectOptionIdFromQuestionList(@BindIn("questionList") List<String> questionList);
}
