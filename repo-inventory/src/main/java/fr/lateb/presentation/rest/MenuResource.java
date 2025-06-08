package fr.lateb.presentation.rest;

import fr.lateb.domain.service.BeerService;
import fr.lateb.util.BeerNotFoundError;
import fr.lateb.util.ErrorInfo;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.TEXT_PLAIN)
public class MenuResource {

    @Inject
    BeerService beerService;

    @GET
    @Path("/")
    public Response getInventory() {
        var beers = beerService.getAllBeers();
        return Response.ok(beers).build();
    }

    @GET
    @Path("/barcode") // Example : /inventory/barcode?id=456879
    public Response getBeeryByBarcode(@QueryParam("id") String barcode) throws BeerNotFoundError {
        var beers =beerService.getBeerById(Long.parseLong(barcode));
        if (beers == null) {
            throw  new BeerNotFoundError("No such barcode in db");
          //  return Response.status(Response.Status.NOT_FOUND).entity(new ErrorInfo("No such barcode in db")).build();

        }
        return Response.ok(beers).build();
    }



}
