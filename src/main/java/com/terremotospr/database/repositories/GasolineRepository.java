package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Gasoline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */
@Repository
public interface GasolineRepository extends CrudRepository<Gasoline, Long> {
}
