package fr.lateb.data.repository;

import fr.lateb.data.domain.EntryModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class EntryRepository implements PanacheRepository<EntryModel> {}
