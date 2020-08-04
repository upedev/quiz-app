package com.cheetahlabs.quiz.handler;

import com.cheetahlabs.quiz.entities.Options;
import com.cheetahlabs.quiz.models.SubmitRequestDTO;
import com.cheetahlabs.quiz.services.OptionService;
import com.cheetahlabs.quiz.services.ResultService;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubmitHandler {

    private OptionService optionService;
    private ResultService resultService;

    @Inject
    public SubmitHandler(OptionService optionService, ResultService resultService) {
        this.optionService = optionService;
        this.resultService = resultService;
    }

    public void calculateAndSaveResult(SubmitRequestDTO submitRequestDTO) {
        Map<String, String> testResponse = submitRequestDTO.getResponseMap();
        List<String> questionList = new ArrayList<>();
        for(String q : testResponse.keySet()) {
            questionList.add(q.replaceFirst("^question-", ""));
        }
        List<Options> correctOptionList = optionService.getOptionListForQuestions(questionList);
        int count = 0;
        for(Options options : correctOptionList) {
            String key = "question-" + options.getQuestionId();
            String selectedOption = testResponse.get(key);
            if(("option-" + options.getId()).equalsIgnoreCase(selectedOption)) {
                count++;
            }
        }
        resultService.saveUserResult(submitRequestDTO.getUserId(), submitRequestDTO.getTestId(), count, 10);

    }
}
