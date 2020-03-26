package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Reserves;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Repository
public interface ReservesRepository extends CrudRepository<Reserves, Long> {
}