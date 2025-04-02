package fr.lateb.domain.entity;

import fr.lateb.types.BeerStatus;

import java.util.Date;
import java.util.UUID;

public record EntryEntity(UUID id, Boolean forSale, Float buyPrice, Date DDM, Date saleDate, Integer order,
                          Long beer, BeerStatus status) {}
