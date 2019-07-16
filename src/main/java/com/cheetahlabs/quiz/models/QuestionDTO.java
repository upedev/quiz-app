package com.cheetahlabs.quiz.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class QuestionDTO {
    private String id;
    private String name;
    private List<OptionDTO> options;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof QuestionDTO)) {
            return false;
        } else {
            return this.id.equals(((QuestionDTO) obj).getId());
        }
    }
}
