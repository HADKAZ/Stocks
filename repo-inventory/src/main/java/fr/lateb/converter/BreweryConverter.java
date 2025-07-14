package fr.lateb.converter;

import fr.lateb.data.model.BreweryModel;
import fr.lateb.domain.entity.BreweryEntity;

public class BreweryConverter {
    public static BreweryEntity toEntity(BreweryModel model) {
        if (model == null)
            return null;

        return new BreweryEntity(model.getName(), model.getCountry(), model.getDescription());
    }

    public static BreweryModel toModel(BreweryEntity entity) {
        if (entity == null)
            return null;

        var model = new BreweryModel();

        model.setCountry(entity.county());
        model.setDescription(entity.description());
        model.setName(entity.name());

        return model;
    }
}
