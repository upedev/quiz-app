package com.cheetahlabs.quiz.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TestDTO {
    private String id;
    private Map<String, SectionDTO> test;
}
