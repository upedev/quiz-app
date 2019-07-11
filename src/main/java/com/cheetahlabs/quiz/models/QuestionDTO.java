package com.cheetahlabs.quiz.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDTO {
    private String id;
    private List<OptionDTO> options;
}
