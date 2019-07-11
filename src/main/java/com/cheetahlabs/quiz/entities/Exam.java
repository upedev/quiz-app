package com.cheetahlabs.quiz.entities;

import lombok.Builder;

@Builder
public class Exam {
    private String id;
    private String name;
    private String description;
}
