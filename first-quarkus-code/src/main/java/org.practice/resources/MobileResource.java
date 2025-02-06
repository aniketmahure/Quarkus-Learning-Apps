package org.practice.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/mobile")
public class MobileResource {
    List<String> mobileList = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN) //Type of data returned
    public Response getMobile(){
        return Response.ok(mobileList).build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN) //Accept data as text
    @Produces(MediaType.TEXT_PLAIN)
    public Response addMobile(String mobileName){
        mobileList.add(mobileName);
        return Response.ok(mobileName).build();
    }

    @PUT
    @Path("/{mobileName}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editMobile(@PathParam("mobileName") String mobileName, @QueryParam("newMobileName") String newMobileName){
        mobileList = mobileList.stream().map(mobile -> {
            if(mobile.equals(mobileName)){
                return newMobileName;
            }else{
                return mobile;
            }
                })
                .collect(Collectors.toList());
        return Response.ok(mobileList).build();
    }

    @DELETE
    @Path("{mobileName}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMobile(@PathParam("mobileName") String mobileName){
        boolean isDeleted = mobileList.remove(mobileName);
        if(isDeleted){
            return Response.ok(mobileList).build();
        }else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
