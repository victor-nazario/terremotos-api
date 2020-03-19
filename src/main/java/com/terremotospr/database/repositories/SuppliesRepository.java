package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Supplies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliesRepository extends CrudRepository<Supplies, Long> {
}
