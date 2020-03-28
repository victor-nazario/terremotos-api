package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Water;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March 12, 2020 - 9:13 PM
 *
 * @author Victor Nazario
 */
@Repository
public interface WaterRepository extends CrudRepository<Water, Long> {
}
