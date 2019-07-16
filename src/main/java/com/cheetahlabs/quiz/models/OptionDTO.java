package com.cheetahlabs.quiz.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OptionDTO {
    private String id;
    private String text;
}
