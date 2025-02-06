package org.practice.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.practice.resources.model.Mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/AllMobiles")
public class MobileDetailResource {

    List<Mobile> mobileDetails = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMobileInfo(){
        return Response.ok(mobileDetails).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMobileInfo(Mobile mobileInfo){
        boolean flag=false;
        flag = mobileDetails.stream().anyMatch(a-> a.getId().equals(mobileInfo.getId()));
        //System.out.println(flag);
        if(!flag){
            mobileDetails.add(mobileInfo);
            return Response.ok("Mobile Added to List").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{mobileId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMobileInfo(@PathParam("mobileId") int mobileId, Mobile mobileInfo){
        mobileDetails = mobileDetails.stream().map(
                a->{
                    if(a.getId().equals(mobileInfo.getId())){
                      return mobileInfo;
                    }
                    return a;
                }
        ).collect(Collectors.toList());
        return Response.ok().build();
    }

    @DELETE
    @Path("{mobileId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMobileInfo(@PathParam("mobileId") int mobileId){
        Optional<Mobile> mobileToDelete = mobileDetails.stream().filter(
                mobile -> mobile.getId().equals(mobileId)
        ).findFirst();
        if(mobileToDelete.isPresent()){
            mobileDetails.remove(mobileToDelete.get());
            return Response.ok(mobileToDelete).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
