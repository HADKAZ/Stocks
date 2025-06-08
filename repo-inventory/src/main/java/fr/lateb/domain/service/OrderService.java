package fr.lateb.domain.service;

import com.google.inject.Inject;
import fr.lateb.data.model.OrderModel;
import fr.lateb.data.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Date;

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
}
