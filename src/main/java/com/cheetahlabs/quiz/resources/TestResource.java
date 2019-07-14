package com.cheetahlabs.quiz.resources;

import com.cheetahlabs.quiz.services.TestService;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/exam")
@Timed
@ExceptionMetered
public class TestResource {
    private TestService testService;

    @Inject
    TestResource(TestService testService) {
        this.testService = testService;
    }

    @Path("/generateTest")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object generateExam(@QueryParam("examID") String examId) {
        return testService.generateRandomTest(examId);
    }
}
