package com.cheetahlabs.quiz.resources;

import com.cheetahlabs.quiz.services.UserService;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @Path("/getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser() {
        return Response.ok(userService.getAllUsers()).build();
    }

}
