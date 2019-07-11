package com.cheetahlabs.quiz.entities;


import lombok.Builder;

@Builder
public class Section {
    private String id;
    private String name;
    private String description;
    private String exam_id;
}
