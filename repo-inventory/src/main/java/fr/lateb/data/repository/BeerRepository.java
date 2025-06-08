package fr.lateb.data.repository;

import fr.lateb.data.model.BeerModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeerRepository implements PanacheRepository<BeerModel> {}
