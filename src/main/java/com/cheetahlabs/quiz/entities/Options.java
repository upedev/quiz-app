package com.cheetahlabs.quiz.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Options {
    private Integer id;
    private String text;
    private String questionId;
    private Boolean isAnswer;
}
