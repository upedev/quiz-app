package com.cheetahlabs.quiz.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@JsonInclude(NON_NULL)
public class Exam {
    private String id;
    private String name;
    private String description;
}
