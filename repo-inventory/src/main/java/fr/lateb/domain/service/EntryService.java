package fr.lateb.domain.service;

import com.google.inject.Inject;
import fr.lateb.converter.EntryConverter;
import fr.lateb.data.model.EntryModel;
import fr.lateb.data.model.OrderModel;
import fr.lateb.data.model.BeerModel;
import fr.lateb.data.repository.EntryRepository;
import fr.lateb.data.repository.OrderRepository;
import fr.lateb.data.repository.BeerRepository;
import fr.lateb.domain.entity.EntryEntity;
import fr.lateb.type.BeerStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;


@ApplicationScoped
public class EntryService {

    @Inject
    EntryRepository entryRepository;

    @Inject
    OrderRepository orderRepository;

    @Inject
    BeerRepository beerRepository;

    @Transactional
    public void registerEntry(Long orderId, Long beerId, Float buyPrice, Date ddm, boolean forSale, BeerStatus status) {
        var entry = new EntryModel();
        entry.setBuyPrice(buyPrice);
        entry.setDDM(ddm);
        entry.setForSale(forSale);
        entry.setStatus(status);

        var order = orderRepository.findById(orderId);
        if (order == null) throw new IllegalArgumentException("Order not found");

        entry.setOrder(order);

        var beer = beerRepository.findById(beerId);
        if (beer == null) throw new IllegalArgumentException("Beer not found");
        entry.setBeer(beer);


        entryRepository.persist(entry);
    }

    public List<EntryEntity> getAllEntries (){
        return entryRepository.findAll().stream().map(EntryConverter::toEntity).toList();
    }
}
