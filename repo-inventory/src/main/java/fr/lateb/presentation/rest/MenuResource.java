package fr.lateb.presentation.rest;

import fr.lateb.domain.entity.BeerEntity;
import fr.lateb.domain.service.BeerService;
import fr.lateb.errors.ErrorsCode;
import fr.lateb.util.BeerNotFoundError;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Inventory", description = "Gestion des bières")
@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
    @Path("/beer") // Example : /inventory/barcode?id=456879
    public Response getBeeryByBarcode(@QueryParam("id") String barcode) throws BeerNotFoundError {
        var beers = beerService.getBeerById(Long.parseLong(barcode));
        return Response.ok(beers).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/beers")
    public Response addBeer(BeerEntity beer) {

        var getBeerResponse = beerService.registerBeer(beer);
        return Response.status(Response.Status.CREATED).entity(getBeerResponse).build();
    }


}
