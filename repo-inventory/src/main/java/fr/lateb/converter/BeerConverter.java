package fr.lateb.converter;

import fr.lateb.data.model.BeerModel;
import fr.lateb.domain.entity.BeerEntity;
import fr.lateb.domain.entity.BeerFormatEntity;
import fr.lateb.domain.entity.BreweryEntity;

public class BeerConverter {
    public static BeerEntity toEntity(BeerModel model) {
        if (model == null)
            return null;
        return new BeerEntity(model.getId(), model.getName(), model.getDescription(), model.getAlcoholPercentage(), BeerFormatConverter.toEntity(model.getFormat()), BreweryConverter.toEntity(model.getBrewery()), BeerTypeConverter.toEntity(model.getType()));
    }

    public static BeerModel toModel(BeerEntity entity) {
        if (entity == null)
            return null;

        var model = new BeerModel();

        model.setId(entity.id());
        model.setAlcoholPercentage(entity.alcoholPercentage());
        model.setDescription(entity.description());
        model.setName(entity.name());
        model.setType(BeerTypeConverter.toModel(entity.type()));
        model.setBrewery(BreweryConverter.toModel(entity.brewery()));
        model.setFormat(BeerFormatConverter.toModel(entity.format()));
        return model;
    }
}
