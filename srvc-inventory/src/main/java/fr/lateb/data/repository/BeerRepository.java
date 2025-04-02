package fr.lateb.data.repository;

import fr.lateb.data.domain.BeerModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class BeerRepository implements PanacheRepository<BeerModel> {}
