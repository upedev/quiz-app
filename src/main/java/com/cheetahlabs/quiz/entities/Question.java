package com.cheetahlabs.quiz.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@Builder
public class Question {
    private String id;
    private String text;
    private String section_id;
    private String exam_id;
    private String test_id;
    private String image_url;
}
