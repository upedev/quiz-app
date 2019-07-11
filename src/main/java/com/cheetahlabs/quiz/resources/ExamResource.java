package com.cheetahlabs.quiz.resources;

import com.cheetahlabs.quiz.services.ExamService;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Timed
@ExceptionMetered
public class ExamResource {
    private ExamService examService;

    @Inject
    ExamResource(ExamService examService) {
        this.examService = examService;
    }

    @Path("/generateExam")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object generateExam(@QueryParam("examID") String examId) {
        return examService.createNewExam(examId);
    }
}
