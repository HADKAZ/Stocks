package fr.lateb.domain.service;

import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.data.repository.BeerTypeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BeerTypeService {

    @Inject
    BeerTypeRepository beerTypeRepository;

    @Transactional
    public void registerBeerType(String type, String description) {
        var existing = beerTypeRepository.find("type", type).firstResult();
        if (existing != null) {
            throw new IllegalArgumentException("Type :'" + type + "', already exists");
        }

        var beerType = new BeerTypeModel();
        beerType.setType(type);
        beerType.setDescription(description);
        beerTypeRepository.persist(beerType);
    }


}
