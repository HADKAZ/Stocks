package fr.lateb.domain.service;

import fr.lateb.converter.BeerConverter;
import fr.lateb.data.model.BeerFormatModel;
import fr.lateb.data.model.BeerModel;
import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.data.repository.BeerRepository;
import fr.lateb.domain.entity.BeerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class BeerService {

    @Inject
    BeerRepository beerRepository;

    @Transactional
    public void registerBeer(Long barcode,String name , String description, Float alcoholPercentage , BeerTypeModel beerTypeModel , BeerFormatModel beerFormatModel) {

        var temp =beerRepository.findById(barcode);
        if(temp != null){
            throw  new IllegalArgumentException("Beer : "+ name + " already exists | barcode : " + barcode);
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
    public boolean unregisterBeer(Long barcode) {
        return beerRepository.deleteById(barcode);
    }

    public List<BeerEntity> getAllBeers() {
        //On sort en fonction du hash du type histoire de grouper les bières du même type ensemble
        return beerRepository.findAll().stream().map(BeerConverter::toEntity).sorted(Comparator.comparing(a -> a.type().hashCode())).toList();
    }

    public BeerEntity getBeerById(Long barcode) {
        return BeerConverter.toEntity(beerRepository.findById(barcode));
    }
}
