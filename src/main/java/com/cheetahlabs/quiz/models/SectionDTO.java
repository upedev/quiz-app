package com.cheetahlabs.quiz.models;

import lombok.Builder;

import java.util.List;


@Builder
public class SectionDTO {
    private String id;
    private String name;
    private List<QuestionDTO> question;
}
