package com.cheetahlabs.quiz.services;

import com.cheetahlabs.quiz.dao.OptionsDao;
import com.cheetahlabs.quiz.entities.Options;
import com.google.inject.Inject;

import java.util.List;

public class OptionService {

    private OptionsDao optionsDao;

    @Inject
    public OptionService(OptionsDao optionsDao) {
        this.optionsDao = optionsDao;
    }

    public List<Options> getOptionListForQuestions(List<String> questionList) {
        return optionsDao.getCorrectOptionIdFromQuestionList(questionList);
    }
}
