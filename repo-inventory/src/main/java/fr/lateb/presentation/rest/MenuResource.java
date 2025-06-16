package fr.lateb.presentation.rest;

import fr.lateb.api.request.GetBeerByRequest;
import fr.lateb.api.request.UnregisterBeerRequest;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/beer")
    public Response addBeer(BeerEntity beer) {

        var getBeerResponse = beerService.registerBeer(beer);
        return Response.status(Response.Status.CREATED).entity(getBeerResponse).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/beer/{field}")
    public Response getBeerBy(@PathParam("field") String field , @QueryParam("field") String value)  {
        var beers = beerService.getBeersBy(field,value);
        return Response.ok().entity(beers).build();
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/beer")
    public Response deleteBeer(UnregisterBeerRequest unregisterBeerRequest) {
        beerService.unregisterBeer(unregisterBeerRequest.id());
        return Response.ok().build();
    }


}
