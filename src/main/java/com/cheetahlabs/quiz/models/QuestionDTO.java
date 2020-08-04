package com.cheetahlabs.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {
    private String id;
    private String name;
    private List<OptionDTO> options;
}
