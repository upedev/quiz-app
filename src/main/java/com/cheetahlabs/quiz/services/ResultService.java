package com.cheetahlabs.quiz.services;

import com.cheetahlabs.quiz.dao.ResultDao;
import com.cheetahlabs.quiz.entities.Result;
import com.google.inject.Inject;

public class ResultService {

    private ResultDao resultDao;

    @Inject
    public ResultService(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    public Result getUserResult(Integer userId, Integer testId){
        return resultDao.getUserResult(userId, testId);
    }

    public void saveUserResult(int userId, int testId, int receivedMarks, int totalMarks) {
        resultDao.saveUserResult(userId, testId, receivedMarks, totalMarks);
    }
}
