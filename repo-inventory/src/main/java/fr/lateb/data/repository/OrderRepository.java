package fr.lateb.data.repository;

import fr.lateb.data.model.OrderModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class OrderRepository implements PanacheRepository<OrderModel> {}
