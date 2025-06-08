package fr.lateb.domain.entity;

import fr.lateb.type.BeerStatus;

import java.util.Date;
import java.util.UUID;

public record EntryEntity(UUID id, Boolean forSale, Float buyPrice, Date DDM, Date saleDate, Long order,
                          Long beer, BeerStatus status) {}
