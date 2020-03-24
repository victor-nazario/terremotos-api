package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Belongs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BelongsRepository extends CrudRepository<Belongs, Long> {
}
