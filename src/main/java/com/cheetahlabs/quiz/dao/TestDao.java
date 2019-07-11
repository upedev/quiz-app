package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.entities.Test;
import com.cheetahlabs.quiz.mappers.TestMapper;
import com.codahale.metrics.annotation.Timed;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TestMapper.class)
public interface TestDao {
    @Timed
    @SqlUpdate("INSERT INTO test VALUES (:newTest.id, :newTest.name, :newTest.description, :newTest.testDump)")
    void insert(@BindBean("newTest") Test newTest);
}
