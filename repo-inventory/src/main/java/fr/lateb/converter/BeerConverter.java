package fr.lateb.converter;

import fr.lateb.data.model.BeerModel;
import fr.lateb.domain.entity.BeerEntity;

public  class BeerConverter {
    public static BeerEntity toEntity(BeerModel model)
    {
        if (model == null)
            return null;
        return new BeerEntity(model.getId(),model.getName(), model.getReference(), model.getAlcoholPercentage(), model.getBrewery() != null ? model.getBrewery().getName() : "", model.getType().getType());
    }

    public static  BeerModel toModel(BeerEntity entity)
    {
        if (entity == null)
            return null;

        var model = new BeerModel();

        model.setId(entity.id());
        model.setAlcoholPercentage(entity.alcoholPercentage());
        model.setReference(entity.reference());
        model.setName(entity.name());
        return model;
    }
}
