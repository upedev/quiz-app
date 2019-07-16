package com.cheetahlabs.quiz.services;

import com.cheetahlabs.quiz.dao.ExamDao;
import com.cheetahlabs.quiz.dao.QuestionDao;
import com.cheetahlabs.quiz.dao.SectionDao;
import com.cheetahlabs.quiz.dao.TestDao;
import com.cheetahlabs.quiz.entities.Question;
import com.cheetahlabs.quiz.entities.Section;
import com.cheetahlabs.quiz.models.OptionDTO;
import com.cheetahlabs.quiz.models.QuestionDTO;
import com.cheetahlabs.quiz.models.SectionDTO;
import com.cheetahlabs.quiz.models.TestDTO;
import com.google.inject.Inject;

import java.util.*;


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

    public String getExamId(String txnId) {
        return null;
}

    public Object generateRandomTest(String examId) {
        TestDTO testDTO = new TestDTO();
        Map<String, SectionDTO> test = new HashMap<>();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Section> sectionList = sectionDao.getAllSectionByExamId(examId); // get all sections for examId
        Random rand = new Random();

        for(Section section : sectionList){
            List<Question> questionList = questionDao.getQuestionsForSection(section.getId(), examId); // get all questions for sectionId
            for(int i = 0; i < 10; i++){
                int randomNumber = rand.nextInt(questionList.size());
                Question randQuestion = questionList.get(randomNumber);

                OptionDTO optionDTO1 = OptionDTO.builder().id("1").text(randQuestion.getOption1()).build();
                OptionDTO optionDTO2 = OptionDTO.builder().id("2").text(randQuestion.getOption2()).build();
                OptionDTO optionDTO3 = OptionDTO.builder().id("3").text(randQuestion.getOption3()).build();
                OptionDTO optionDTO4 = OptionDTO.builder().id("4").text(randQuestion.getOption4()).build();
                List<OptionDTO> optionDTOList = new ArrayList<>();
                optionDTOList.add(optionDTO1);
                optionDTOList.add(optionDTO2);
                optionDTOList.add(optionDTO3);
                optionDTOList.add(optionDTO4);

                QuestionDTO questionDTO = QuestionDTO.builder()
                        .id(questionList.get(randomNumber).getId())
                        .name(randQuestion.getDescription())
                        .options(optionDTOList)
                        .build();
                questionDTOList.add(questionDTO);
            }

            SectionDTO sectionDTO = SectionDTO.builder()
                    .id(section.getId())
                    .name(section.getName())
                    .question(questionDTOList).build();

            test.put(section.getName(), sectionDTO);
        }
        testDTO.setTest(test);

        // insert create test to table
//        testDao.insert();

        return true;
    }
}
