package fr.lateb.data.domain;

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
    public Boolean sellable;

    @NonNull
    public Float buyPrice;

    @NonNull
    public Date DDM;

    @Nullable
    public Date saleDate;

    @NonNull
    @ManyToOne
    public BeerFormatModel format;

    @ManyToOne
    @NonNull
    public OrderModel order;

    @Enumerated
    @NonNull
    public BeerStatus status = BeerStatus.STORED;
}
