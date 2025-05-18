package fr.lateb.converter;

import fr.lateb.data.model.BeerModel;
import fr.lateb.domain.entity.BeerEntity;

public class BeerConverter {
    public BeerEntity toEntity(BeerModel model)
    {
        if (model == null)
            return null;
        return new BeerEntity(model.getId(), model.getReference(), model.getAlcoholPercentage(), model.getBrewery().getName(), model.getType().getType());
    }

    public BeerModel toModel(BeerEntity entity)
    {
        if (entity == null)
            return null;

        var model = new BeerModel();

        model.setId(entity.id());
        model.setAlcoholPercentage(entity.alcoholPercentage());
        model.setReference(entity.reference());

        return model;
    }
}
