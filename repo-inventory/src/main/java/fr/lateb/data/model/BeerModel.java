package fr.lateb.data.model;

import jakarta.annotation.Nullable;
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
    public String name;

    @NonNull
    public String reference;

    @NonNull
    public Float alcoholPercentage;

    @ManyToOne
    @Nullable
    public BreweryModel brewery;

    @ManyToOne
    @NonNull
    public BeerTypeModel type;

    @NonNull
    @ManyToOne
    public BeerFormatModel format;
}
