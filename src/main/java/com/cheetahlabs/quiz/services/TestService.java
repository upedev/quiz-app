package com.cheetahlabs.quiz.services;

import com.cheetahlabs.quiz.dao.ExamDao;
import com.cheetahlabs.quiz.dao.QuestionDao;
import com.cheetahlabs.quiz.dao.SectionDao;
import com.cheetahlabs.quiz.dao.TestDao;
import com.cheetahlabs.quiz.entities.Test;
import com.google.inject.Inject;

import java.util.List;


public class TestService {

    ExamDao examDao;
    SectionDao sectionDao;
    QuestionDao questionDao;
    TestDao testDao;

    @Inject
    TestService(ExamDao examDao, SectionDao sectionDao, QuestionDao questionDao, TestDao testDao) {
        this.examDao = examDao;
        this.sectionDao = sectionDao;
        this.questionDao = questionDao;
        this.testDao = testDao;
    }

//    public String getExamId(String txnId) {
//        return examDao(txnId);
//    }

    public Object generateRandomTest(String examId) {
        return null;
    }

    public List<Test> getActiveTest() {
        return testDao.getActiveTests(System.currentTimeMillis());
    }
}
