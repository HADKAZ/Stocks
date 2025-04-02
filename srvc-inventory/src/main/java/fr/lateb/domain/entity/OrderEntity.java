package fr.lateb.domain.entity;

import java.util.Date;

public record OrderEntity(Integer id, String supplier, Date arrivalDate) {}
