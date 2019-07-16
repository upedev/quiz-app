package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.entities.Question;
import com.cheetahlabs.quiz.mappers.QuestionMapper;
import com.codahale.metrics.annotation.Timed;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(QuestionMapper.class)
public interface QuestionDao {
    @Timed
    @SqlQuery("SELECT * FROM questions WHERE section_id = :sectionId and exam_id = :examId")
    List<Question> getQuestionsForSection(@Bind("sectionId") String sectionId, @Bind("examId") String examId);
}
