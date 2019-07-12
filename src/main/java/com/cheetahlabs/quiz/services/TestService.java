package com.cheetahlabs.quiz.services;

import com.cheetahlabs.quiz.dao.ExamDao;
import com.cheetahlabs.quiz.dao.QuestionDao;
import com.cheetahlabs.quiz.dao.SectionDao;
import com.google.inject.Inject;


public class TestService {

    ExamDao examDao;
    SectionDao sectionDao;
    QuestionDao questionDao;

    @Inject
    TestService(ExamDao examDao, SectionDao sectionDao, QuestionDao questionDao) {
        this.examDao = examDao;
        this.sectionDao = sectionDao;
        this.questionDao = questionDao;
    }

//    public String getExamId(String txnId) {
//        return examDao(txnId);
//    }

    public Object generateRandomTest(String examId) {
        return null;
    }
}
