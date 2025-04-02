package fr.lateb.converter;

import fr.lateb.data.model.OrderModel;
import fr.lateb.domain.entity.OrderEntity;

public class OrderConverter {
    public OrderEntity toEntity(OrderModel model)
    {
        if (model == null)
            return null;

        return new OrderEntity(model.getId(), model.getSupplier(), model.getArrivalDate());
    }

    public OrderModel toModel(OrderEntity entity)
    {
        if (entity == null)
            return null;

        var model = new OrderModel();

        model.setId(entity.id());
        model.setArrivalDate(entity.arrivalDate());
        model.setSupplier(entity.supplier());

        return model;
    }
}
