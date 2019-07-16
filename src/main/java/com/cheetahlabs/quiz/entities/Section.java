package com.cheetahlabs.quiz.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)
public class Section {
    private String id;
    private String name;
    private String description;
    private String exam_id;
}
