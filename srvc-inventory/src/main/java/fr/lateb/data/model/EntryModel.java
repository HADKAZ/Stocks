package fr.lateb.data.model;

import fr.lateb.types.BeerStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class EntryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @NonNull
    public Boolean forSale;

    @NonNull
    public Float buyPrice;

    @NonNull
    public Date DDM;

    @Nullable
    public Date saleDate;

    @ManyToOne
    @NonNull
    public OrderModel order;

    @ManyToOne
    public BeerModel beer;

    @Enumerated
    @NonNull
    public BeerStatus status = BeerStatus.STORED;
}
