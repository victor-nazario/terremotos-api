package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.CannedFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface CannedFoodRepository extends CrudRepository<CannedFood,Long> {
}