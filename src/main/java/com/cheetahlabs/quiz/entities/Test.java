package com.cheetahlabs.quiz.entities;

import com.cheetahlabs.quiz.models.TestDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@JsonInclude(NON_NULL)
public class Test {
    private String id;
    private String name;
    private String description;
    private TestDTO dump;
    private String duration;
}
