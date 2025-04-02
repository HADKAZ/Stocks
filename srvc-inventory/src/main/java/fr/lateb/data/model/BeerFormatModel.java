package fr.lateb.data.model;

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
    public String name;

    @NonNull
    public Float size;
}
