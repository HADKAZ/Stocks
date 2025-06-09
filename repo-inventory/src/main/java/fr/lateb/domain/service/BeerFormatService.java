package fr.lateb.domain.service;

import fr.lateb.data.model.BeerFormatModel;
import fr.lateb.data.repository.BeerFormatRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BeerFormatService {

    @Inject
    BeerFormatRepository beerFormatRepository;

    @Transactional
    public void registerBeerFormat(String name, Float size) {

        var format = new BeerFormatModel();
        format.setName(name);
        format.setSize(size);
        beerFormatRepository.persist(format);
    }


}
