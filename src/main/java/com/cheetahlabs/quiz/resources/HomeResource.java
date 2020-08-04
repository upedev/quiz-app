package com.cheetahlabs.quiz.resources;

import com.cheetahlabs.quiz.entities.Options;
import com.cheetahlabs.quiz.entities.Result;
import com.cheetahlabs.quiz.handler.SubmitHandler;
import com.cheetahlabs.quiz.models.SubmitRequestDTO;
import com.cheetahlabs.quiz.services.OptionService;
import com.cheetahlabs.quiz.services.ResultService;
import com.cheetahlabs.quiz.views.HomeView;
import com.cheetahlabs.quiz.views.SubmitView;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.Map;

@Timed
@Path("/")
@ExceptionMetered
public class HomeResource {

    private HomeView homeView;
    private SubmitView submitView;
    private SubmitHandler submitHandler;
    private ResultService resultService;

    @Inject
    public HomeResource(HomeView homeView, SubmitView submitView, SubmitHandler submitHandler, ResultService resultService) {
        this.homeView = homeView;
        this.submitView = submitView;
        this.submitHandler = submitHandler;
        this.resultService = resultService;
    }

    @Path("/")
    @GET
    public Response getHome() {
        return Response.ok().entity(homeView).cookie(new NewCookie("user_id", "1")).build();
    }

    @Path("/submit")
    @POST
    public Response submit(SubmitRequestDTO submitRequestDTO) {
        submitHandler.calculateAndSaveResult(submitRequestDTO);
        return Response.ok().entity(new HashMap<String, String >()).build();
    }

    @Path("/submitResult")
    @GET
    public Response getResult(@Context HttpHeaders httpHeaders) {
        Map<String, Cookie> cookieMap = httpHeaders.getCookies();
        Integer userId = Integer.valueOf(cookieMap.get("user_id").getValue());
        Integer testId = Integer.valueOf(cookieMap.get("test_id").getValue());
        Result userResult = resultService.getUserResult(userId,testId);
        submitView.setUserResult(userResult);
        return Response.ok().entity(submitView).build();
    }

}
