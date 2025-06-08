package fr.lateb.domain.service;

import fr.lateb.data.model.BeerFormatModel;
import fr.lateb.data.model.BeerModel;
import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.data.repository.BeerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BeerService {

    @Inject
    BeerRepository beerRepository;

    @Transactional
    public void registerBeer(Long barcode, String reference, Float alcoholPercentage , BeerTypeModel beerTypeModel , BeerFormatModel beerFormatModel) {

        var temp =beerRepository.findById(barcode);
        if(temp != null){
            throw  new IllegalArgumentException("Beer : "+ reference + " already exists | barcode : " + barcode);
        }
        var newBeer = new BeerModel();
        newBeer.setId(barcode);
        newBeer.setReference(reference);
        newBeer.setAlcoholPercentage(alcoholPercentage);
        newBeer.setType(beerTypeModel);
        newBeer.setFormat(beerFormatModel);
        beerRepository.persist(newBeer);
    }

    @Transactional
    public void unregisterBeer(Long barcode) {
        boolean success = beerRepository.deleteById(barcode);
    }
}
