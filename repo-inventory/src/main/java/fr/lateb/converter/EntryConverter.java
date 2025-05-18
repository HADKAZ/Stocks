package fr.lateb.converter;

import fr.lateb.data.model.BeerModel;
import fr.lateb.data.model.EntryModel;
import fr.lateb.data.model.OrderModel;
import fr.lateb.domain.entity.EntryEntity;

public class EntryConverter {
    public EntryEntity toEntity(EntryModel model) {
        if (model == null)
            return null;

        return new EntryEntity(model.getId(), model.getForSale(), model.getBuyPrice(), model.getDDM(),
                model.getSaleDate(), model.getOrder().getId(), model.getBeer().getId(), model.getStatus());
    }

    public EntryModel toModel(EntryEntity entity, BeerModel beer, OrderModel order)
    {
        if (entity == null)
            return null;

        var model = new EntryModel();
        model.setBeer(beer);
        model.setOrder(order);
        model.setBuyPrice(entity.buyPrice());
        model.setDDM(entity.DDM());
        model.setForSale(entity.forSale());
        model.setId(entity.id());
        model.setSaleDate(entity.saleDate());
        model.setStatus(entity.status());

        return model;
    }
}
