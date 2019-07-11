package com.cheetahlabs.quiz.services;

import javax.ws.rs.core.Response;

public class ExamService {
    public Response createNewExam(String examId) {
        return Response.accepted().build();
    }
}
