package org.practice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.practice.model.TvShows;

@Path("/shows")
@RegisterRestClient(baseUri = "https://api.tvmaze.com")
public interface TvSeriesProxy {

    //https://api.tvmaze.com/shows/3
    @GET
    @Path("/{id}")
    TvShows getTvShowsById(@PathParam("id") int id);
}
