package com.github.atdi.golight.resources;

import com.github.atdi.golight.services.Hello;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 * Dummy rest resource.
 */
@Path("/")
public class DummyResource {

    private final Hello helloService;

    @Inject
    public DummyResource(Hello helloService) {
        this.helloService = helloService;
    }


    @GET
    @Path("{name}")
    public String sayHello(@PathParam("name") String name) {
        return helloService.sayHelloTo(name);
    }
}
