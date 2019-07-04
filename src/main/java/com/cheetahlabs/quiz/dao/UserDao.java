package com.cheetahlabs.quiz.dao;

import com.cheetahlabs.quiz.mappers.UserMapper;
import com.cheetahlabs.quiz.models.User;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(UserMapper.class)
public interface UserDao {

    @SqlQuery("select * from users")
    List<User> getAllUseres();

}
