package com.cheetahlabs.quiz.services;

import com.cheetahlabs.quiz.dao.UserDao;
import com.cheetahlabs.quiz.models.User;
import com.google.inject.Inject;

import java.util.List;

public class UserService {

    @Inject UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUseres();
    }
}
