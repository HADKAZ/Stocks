package fr.lateb.data.model;

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
    public Float alcoholPercentage;

    @ManyToOne
    @NonNull
    public BreweryModel brewery;

    @ManyToOne
    @NonNull
    public BeerTypeModel type;

    @NonNull
    @ManyToOne
    public BeerFormatModel format;
}
