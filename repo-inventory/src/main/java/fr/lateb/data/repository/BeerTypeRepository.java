package fr.lateb.data.repository;

import fr.lateb.data.model.BeerTypeModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeerTypeRepository implements PanacheRepository<BeerTypeModel> {
}