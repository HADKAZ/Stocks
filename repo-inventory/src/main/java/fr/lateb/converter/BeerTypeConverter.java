package fr.lateb.converter;

import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.domain.entity.BeerTypeEntity;

public class BeerTypeConverter {
    public static BeerTypeEntity toEntity(BeerTypeModel model)
    {
        if (model == null)
            return null;

        return new BeerTypeEntity(model.getType(), model.getDescription());
    }

    public static BeerTypeModel toModel(BeerTypeEntity entity)
    {
        if (entity == null)
            return null;

        var model = new BeerTypeModel();

        model.setType(entity.type());
        model.setDescription(entity.description());

        return model;
    }
}
