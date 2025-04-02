package fr.lateb.data.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class BeerTypeModel {
    @Id
    public String type;

    @Lob
    public String description;

    @OneToMany
    public List<BeerModel> beers;
}
