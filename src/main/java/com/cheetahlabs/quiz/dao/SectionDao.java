package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.entities.Section;
import com.cheetahlabs.quiz.mappers.SectionMapper;
import com.codahale.metrics.annotation.Timed;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(SectionMapper.class)
public interface SectionDao {
    @Timed
    @SqlQuery("SELECT * FROM sections WHERE exam_id = :examId")
    List<Section> getAllSectionByExamId(@Bind("examId") String examId);
}