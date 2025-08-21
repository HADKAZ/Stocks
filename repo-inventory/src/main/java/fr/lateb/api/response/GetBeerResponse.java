package fr.lateb.api.response;

import fr.lateb.data.model.BeerModel;
import fr.lateb.domain.entity.BeerEntity;
import lombok.Value;

@Value
public class GetBeerResponse {
    Long barcode;
    String name;
    String description;
    Float alcoholPercentage;
    String format;
    String type;
    String brewery;

    public static GetBeerResponse fromModel(BeerModel beer) {

        var formatString = beer.getFormat() != null ? beer.getFormat().getSize() + "cl" : "Unknown";
        var typeStr = beer.getType() != null ? beer.getType().getType() : "Unknown";
        var breweryStr = beer.getBrewery() != null ? beer.getBrewery().getName() : "Unknown";
        return new GetBeerResponse(beer.id, beer.name, beer.description, beer.alcoholPercentage, formatString, typeStr, breweryStr);

    }

    public static GetBeerResponse fromEntity(BeerEntity beer) {

        var formatString = beer.format() != null ? beer.format().size() + "cl" : "Unknown";
        var typeStr = beer.type() != null ? beer.type().type() : "Unknown";
        var breweryStr = beer.brewery() != null ? beer.brewery().name() : "Unknown";
        return new GetBeerResponse(beer.id(), beer.name(), beer.description(), beer.alcoholPercentage(), formatString, typeStr, breweryStr);

    }
}
