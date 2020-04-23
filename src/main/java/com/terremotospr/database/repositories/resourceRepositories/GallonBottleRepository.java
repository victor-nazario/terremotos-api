package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.GallonBottle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface GallonBottleRepository extends CrudRepository<GallonBottle, Long> {
}
