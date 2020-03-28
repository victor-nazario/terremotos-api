package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.SmallBottle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface SmallBottleRepository extends CrudRepository<SmallBottle,Long> {
}
