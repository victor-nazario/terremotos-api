package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Manages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
@Repository
public interface ManagesRepository extends CrudRepository<Manages, Long> {
}
