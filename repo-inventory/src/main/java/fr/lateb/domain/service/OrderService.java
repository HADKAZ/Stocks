package fr.lateb.domain.service;

import fr.lateb.converter.OrderConverter;
import fr.lateb.data.model.OrderModel;
import fr.lateb.data.repository.OrderRepository;
import fr.lateb.domain.entity.OrderEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Transactional
    public void registerOrder(Long id, String supplier, Date arrivalDate) {
        if (orderRepository.findById(id) != null) {
            throw new IllegalArgumentException("Order with id " + id + " , already exists");
        }

        var order = new OrderModel();
        order.setId(id);
        order.setSupplier(supplier);
        order.setArrivalDate(arrivalDate);

        orderRepository.persist(order);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderConverter::toEntity).
                sorted(Comparator.comparing(a -> a.arrivalDate())).toList();
    }
}
