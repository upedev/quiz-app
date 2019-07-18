package com.cheetahlabs.quiz.resources;

import com.cheetahlabs.quiz.entities.Test;
import com.cheetahlabs.quiz.services.TestService;
import com.cheetahlabs.quiz.views.ActiveTestListView;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/test")
@Timed
@ExceptionMetered
public class TestResource {
    private TestService testService;
    private  ActiveTestListView activeTestListView;

    @Inject
    TestResource(TestService testService, ActiveTestListView activeTestListView) {
        this.testService = testService;
        this.activeTestListView = activeTestListView;
    }

    @Path("/generateTest")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object generateExam(@QueryParam("examID") String examId) {
        return testService.generateRandomTest(examId);
    }

    @Path("/getActiveTests")
    @GET
    public Response getActiveTests() {
//        List<Test> activeTests = testService.getActiveTest();
//        activeTestListView.setActiveTests(activeTests);
        return Response.ok().entity(activeTestListView).build();
    }
}
