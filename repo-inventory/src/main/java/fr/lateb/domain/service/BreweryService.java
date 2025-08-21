package fr.lateb.domain.service;

import fr.lateb.data.model.BreweryModel;
import fr.lateb.data.repository.BreweryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BreweryService {

    @Inject
    BreweryRepository breweryRepository;

    public void registerBrewery(String name, String description) {
        var nBrewery = new BreweryModel();
        nBrewery.setName(name);
        nBrewery.setDescription(description);
        breweryRepository.persist(nBrewery);
    }


}
