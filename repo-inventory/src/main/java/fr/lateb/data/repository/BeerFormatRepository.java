package fr.lateb.data.repository;

import fr.lateb.data.model.BeerFormatModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeerFormatRepository implements PanacheRepository<BeerFormatModel> {
}
