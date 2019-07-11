package com.cheetahlabs.quiz.entities;

import com.cheetahlabs.quiz.models.TestDTO;
import lombok.Builder;

@Builder
public class Test {
    private String id;
    private String name;
    private String description;
    private TestDTO dump;
    private String duration;
}
