package com.cheetahlabs.quiz.resources;

import com.cheetahlabs.quiz.entities.Test;
import com.cheetahlabs.quiz.models.TestDTO;
import com.cheetahlabs.quiz.services.TestService;
import com.cheetahlabs.quiz.views.ActiveTestListView;
import com.cheetahlabs.quiz.views.TestView;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/test")
@Timed
@ExceptionMetered
public class TestResource {
    private TestService testService;
    private  ActiveTestListView activeTestListView;
    private TestView testView;

    @Inject
    TestResource(TestService testService, ActiveTestListView activeTestListView, TestView testView) {
        this.testService = testService;
        this.activeTestListView = activeTestListView;
        this.testView = testView;
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
        List<Test> activeTests = testService.getActiveTest();
        List<Test> upcomingTests = testService.getUpcomingTests();
        activeTestListView.setActiveTests(activeTests);
        activeTestListView.setUpcomingTests(upcomingTests);
        return Response.ok().entity(activeTestListView).build();
    }

    @Path("/{test_id}")
    @GET
    public Response getTest(@PathParam("test_id") String testId, @Context HttpHeaders httpHeaders) {
        TestDTO test = testService.getTest(testId);
        testView.setTest(test);
        return Response.ok().entity(testView).cookie(new NewCookie("test_id", testId, "/", "", "comment", 100, false)).build();
    }
}
