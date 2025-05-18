package fr.lateb.data.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
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
    @Nullable
    public String description;

    @OneToMany
    public List<BeerModel> beers;
}
