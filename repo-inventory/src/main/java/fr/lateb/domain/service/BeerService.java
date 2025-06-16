package fr.lateb.domain.service;

import fr.lateb.api.request.GetBeerByRequest;
import fr.lateb.api.response.GetBeerResponse;
import fr.lateb.converter.BeerConverter;
import fr.lateb.converter.BeerFormatConverter;
import fr.lateb.converter.BeerTypeConverter;
import fr.lateb.converter.BreweryConverter;
import fr.lateb.data.model.BeerFormatModel;
import fr.lateb.data.model.BeerModel;
import fr.lateb.data.model.BeerTypeModel;
import fr.lateb.data.repository.BeerFormatRepository;
import fr.lateb.data.repository.BeerRepository;
import fr.lateb.data.repository.BeerTypeRepository;
import fr.lateb.data.repository.BreweryRepository;
import fr.lateb.domain.entity.BeerEntity;
import fr.lateb.errors.ErrorsCode;
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
    @Inject
    BreweryRepository breweryRepository;
    @Inject
    BeerFormatRepository beerFormatRepository;


    @Transactional
    public void registerBeer(Long barcode, String name, String description, Float alcoholPercentage, BeerTypeModel beerTypeModel, BeerFormatModel beerFormatModel) {

        var temp = beerRepository.findById(barcode);
        if (temp != null)
          ErrorsCode.BEER_ALREADY_EXISTS.throwException(barcode);

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
    public GetBeerResponse registerBeer(BeerEntity beer) {


        var beerModel = beerRepository.findById(beer.id());
        if (beerModel != null)
            ErrorsCode.BEER_ALREADY_EXISTS.throwException(beerModel.name);

        var newBeer = BeerConverter.toModel(beer);
        var brewery = newBeer.getBrewery();
        var format = newBeer.getFormat();
        var type = newBeer.getType();


        if(breweryRepository.find("name",beer.brewery().name()).firstResult() == null) // To prevent transient error
            breweryRepository.persist(brewery);
        brewery = breweryRepository.find("name",beer.brewery().name()).firstResult();

        if(beerFormatRepository.find("name",beer.format().name()).firstResult() == null)// To prevent transient error
            beerFormatRepository.persist(format);
        format = beerFormatRepository.find("name",beer.format().name()).firstResult();

        if(beerTypeRepository.find("type",beer.type().type()).firstResult() == null)// To prevent transient error
            beerTypeRepository.persist(type);
        type = beerTypeRepository.find("type",beer.type().type()).firstResult();

        newBeer.setBrewery(brewery);
        newBeer.setFormat(format);
        newBeer.setType(type);

        beerRepository.persist(newBeer);
        return GetBeerResponse.fromModel(beerRepository.findById(newBeer.getId()));
    }

    @Transactional
    public void unregisterBeer(Long barcode) {
        var beerModel = beerRepository.findById(barcode);
        if(beerModel != null)
            ErrorsCode.BEER_NOT_FOUND.throwException(beerModel.name);
        beerRepository.deleteById(barcode);
    }

    @Transactional
    public List<GetBeerResponse> getAllBeers() {

        return beerRepository.findAll().stream().map(GetBeerResponse::fromModel).toList();
    }

    @Transactional
    public List<GetBeerResponse> getBeersBy(String field , String value) {
        try{
           return beerRepository.find(field , value).stream().map(GetBeerResponse::fromModel).toList();
        }catch(Exception e){
            ErrorsCode.INVALID_FIELD.throwException(field);
        }
        return null;
    }

    public BeerEntity getBeerById(Long barcode) {
        return BeerConverter.toEntity(beerRepository.findById(barcode));
    }

}
