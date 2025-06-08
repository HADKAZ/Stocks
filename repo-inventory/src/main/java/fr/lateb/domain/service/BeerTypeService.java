package fr.lateb.domain.service;

import com.google.inject.Inject;
import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.data.repository.BeerTypeRepository;
import jakarta.enterprise.context.ApplicationScoped;
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
