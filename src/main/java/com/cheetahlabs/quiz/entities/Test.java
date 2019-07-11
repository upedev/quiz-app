package com.cheetahlabs.quiz.entities;

import com.cheetahlabs.quiz.models.TestDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Test {
    private String id;
    private String name;
    private String description;
    private TestDTO testDump;
}
