package fr.lateb.data.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class BeerModel {
    @Id
    public Long id; // Bar code

    @NonNull
    public String reference;

    @NonNull
    public Float alcoolPercentage;

    @ManyToOne
    @NonNull
    public BreweryModel brewery;

    @ManyToOne
    @NonNull
    public BeerTypeModel type;
}
