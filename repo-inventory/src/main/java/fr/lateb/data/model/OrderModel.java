package fr.lateb.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class OrderModel {
    @Id
    public Integer id;

    @NonNull
    public String supplier;

    @NonNull
    public Date arrivalDate;

    @OneToMany
    public List<BeerModel> arrivals;
}
