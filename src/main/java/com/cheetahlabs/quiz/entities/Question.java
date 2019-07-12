package com.cheetahlabs.quiz.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@Builder
@JsonInclude(NON_NULL)
public class Question {
    private String id;
    private String section_id;
    private String exam_id;
    private String test_id;
    private String description;
    private String image_url;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String is_option_1;
    private String is_option_2;
    private String is_option_3;
    private String is_option_4;
}
