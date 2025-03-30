package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/data")
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(){
        List<MyEntity> listOfEmployee = MyEntity.listAll();
        return Response.ok(listOfEmployee).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDataById(@PathParam("id") Long id){
        MyEntity empData = MyEntity.findById(id);
        if (empData.isPersistent()){
            return Response.ok(empData).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Transactional   // required in case of data modification
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addData(MyEntity empdata){
        MyEntity.persist(empdata);
        if (empdata.isPersistent()){
//            return Response.created(URI.create("/added to id : /")).build();
            return Response.status(Response.Status.CREATED).entity("Employee Added Successfully").build();

        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
