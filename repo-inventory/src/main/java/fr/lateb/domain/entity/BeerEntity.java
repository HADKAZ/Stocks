package fr.lateb.domain.entity;

public record BeerEntity(Long id, String name, String description, Float alcoholPercentage, String brewery,
                         BeerTypeEntity type) {

}
