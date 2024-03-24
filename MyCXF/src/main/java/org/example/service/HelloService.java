package org.example.service;

import org.example.entity.TestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/helloService")
public class HelloService {

    @POST
    @Path("/sayHello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
//    @ResponseBody
    public TestEntity sayHello(@RequestBody TestEntity testEntity) {
        return testEntity;
    }
}
