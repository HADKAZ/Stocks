package fr.lateb.data.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class BeerFormatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NonNull
    public Float size; // In Cl

    @NonNull
    public String name;
}
