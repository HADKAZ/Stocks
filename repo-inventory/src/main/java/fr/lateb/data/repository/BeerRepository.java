package fr.lateb.data.repository;

import fr.lateb.data.model.BeerModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class BeerRepository implements PanacheRepository<BeerModel> {}
