package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Battery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface BatteryRepository extends CrudRepository<Battery, Long> {
}
