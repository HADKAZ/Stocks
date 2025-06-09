package fr.lateb.domain.service;

import fr.lateb.converter.BeerConverter;
import fr.lateb.data.model.BeerFormatModel;
import fr.lateb.data.model.BeerModel;
import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.data.repository.BeerRepository;
import fr.lateb.data.repository.BeerTypeRepository;
import fr.lateb.domain.entity.BeerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BeerService {

    @Inject
    BeerRepository beerRepository;
    @Inject
    BeerTypeRepository beerTypeRepository;

    @Transactional
    public void registerBeer(Long barcode, String name, String description, Float alcoholPercentage, BeerTypeModel beerTypeModel, BeerFormatModel beerFormatModel) {

        var temp = beerRepository.findById(barcode);
        if (temp != null) {
            throw new IllegalArgumentException("Beer : " + name + " already exists | barcode : " + barcode);
        }
        var newBeer = new BeerModel();
        newBeer.setId(barcode);
        newBeer.setDescription(description);
        newBeer.setName(name);
        newBeer.setAlcoholPercentage(alcoholPercentage);
        newBeer.setType(beerTypeModel);
        newBeer.setFormat(beerFormatModel);
        beerRepository.persist(newBeer);
    }

    @Transactional
    public void registerBeer(BeerEntity beer) {


        var temp = beerRepository.findById(beer.id());
        if (temp != null) {
            throw new IllegalArgumentException("Beer : " + beer.name() + " already exists | barcode : " + beer.id());
        }
        var newBeer = BeerConverter.toModel(beer);
        beerTypeRepository.persist(newBeer.getType());
        beerRepository.persist(newBeer);
    }

    @Transactional
    public boolean unregisterBeer(Long barcode) {
        return beerRepository.deleteById(barcode);
    }

    @Transactional
    public List<BeerEntity> getAllBeers() {
        //On sort en fonction du hash du type histoire de grouper les bières du même type ensemble
        return beerRepository.findAll().stream().map(BeerConverter::toEntity).toList();
    }

    public BeerEntity getBeerById(Long barcode) {
        return BeerConverter.toEntity(beerRepository.findById(barcode));
    }
}
