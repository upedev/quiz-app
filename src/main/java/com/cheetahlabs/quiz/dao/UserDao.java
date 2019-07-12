package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.entities.User;
import com.cheetahlabs.quiz.mappers.UserMapper;
import com.codahale.metrics.annotation.Timed;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;


public interface UserDao {
    @Timed
    @SqlQuery("select id from users")
    @RegisterMapper(UserMapper.class)
    List<User> getAllUsers();
}
