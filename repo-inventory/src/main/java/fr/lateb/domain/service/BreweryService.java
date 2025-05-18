package fr.lateb.domain.service;

import fr.lateb.data.model.BreweryModel;
import fr.lateb.data.repository.BreweryRepository;
import fr.lateb.domain.entity.BreweryEntity;
import jakarta.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

@ApplicationScoped
public class BreweryService {

    @Inject
    BreweryRepository breweryRepository;

    public void registerBrewery(String name, String description) {
        breweryRepository.persist(new BreweryModel(name = name, description = description));
    }
}
