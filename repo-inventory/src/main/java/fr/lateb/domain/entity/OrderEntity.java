package fr.lateb.domain.entity;

import java.util.Date;

public record OrderEntity(Long id, String supplier, Date arrivalDate) {}
