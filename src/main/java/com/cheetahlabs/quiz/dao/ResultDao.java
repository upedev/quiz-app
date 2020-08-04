package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.entities.Result;
import com.cheetahlabs.quiz.mappers.ResultMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ResultMapper.class)
public interface ResultDao {

    @SqlQuery("SELECT * from result where user_id = :userId AND test_id = :testId")
    Result getUserResult(@Bind("userId") Integer userId, @Bind("testId") Integer testId);

    @SqlUpdate("INSERT INTO `result` (`test_id`, `user_id`, `received_marks`, `total_marks`) VALUES (:testId, :userId, :receivedMarks, :totalMarks)")
    void saveUserResult(@Bind("userId") Integer userId, @Bind("testId") Integer testId, @Bind("receivedMarks") Integer receivedMarks, @Bind("totalMarks") Integer totalMarks);
}
