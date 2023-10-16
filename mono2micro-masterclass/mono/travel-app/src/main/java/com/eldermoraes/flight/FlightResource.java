package com.eldermoraes.flight;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("flights")
public class FlightResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> flights() {
        return Flight.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Flight newFlight(Flight flight) {
        flight.id = null;
        flight.persist();
        return flight;
    }

}