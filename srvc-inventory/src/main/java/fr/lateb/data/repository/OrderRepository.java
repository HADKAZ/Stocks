package fr.lateb.data.repository;

import fr.lateb.data.domain.OrderModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class OrderRepository implements PanacheRepository<OrderModel> {}
