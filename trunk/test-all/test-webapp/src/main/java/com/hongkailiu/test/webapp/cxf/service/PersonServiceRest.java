package com.hongkailiu.test.webapp.cxf.service;

import com.hongkailiu.test.webapp.cxf.vo.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//REST Setup (Follows JAX-RS)
@Path("/person") public interface PersonServiceRest {

    @POST @Path("/") @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person create(Person person);

    @GET @Path("/{id}") @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    //@Produces({ MediaType.APPLICATION_JSON })
    public Person read(@PathParam("id") String id);

    @PUT @Path("/{id}") @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(@PathParam("id") String uuid, Person person);

    @DELETE @Path("/{id}") @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") String uuid);
}
