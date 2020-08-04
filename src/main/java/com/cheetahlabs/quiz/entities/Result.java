package com.cheetahlabs.quiz.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Result {
    private int id;
    private int userId;
    private int testId;
    private float  marksObtained;
    private float totalMarks;
}
