package fr.lateb.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class BreweryModel {
    @Id
    public String name;

    @Column(length = 64)
    @NonNull
    public String country;

    @Lob
    public String description;

    @OneToMany
    public List<BeerModel> beers;
}
