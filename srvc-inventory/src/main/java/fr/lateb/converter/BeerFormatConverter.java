package fr.lateb.converter;

import fr.lateb.data.model.BeerFormatModel;
import fr.lateb.domain.entity.BeerFormatEntity;

public class BeerFormatConverter {
    public BeerFormatEntity toEntity(BeerFormatModel model)
    {
        if (model == null)
            return null;

        return new BeerFormatEntity(model.getName(), model.getSize());
    }

    public BeerFormatModel toModel(BeerFormatEntity entity)
    {
        if (entity == null)
            return null;

        var model = new BeerFormatModel();

        model.setName(entity.name());
        model.setSize(entity.size());

        return model;
    }
}
