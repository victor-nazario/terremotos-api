package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Reserves;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
public interface ReservesRepository extends CrudRepository<Reserves, Long> {
}
