package org.practice;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.practice.model.TvShows;

@Path("/TvSeries")
public class GreetingResource {

    @Inject
    @RestClient
    TvSeriesProxy tvSeriesProxy;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TvShows getTvSeriesById(@PathParam("id") int id) {
        return tvSeriesProxy.getTvShowsById(id);
    }

}
