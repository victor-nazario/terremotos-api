package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.DryFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface DryFoodRepository extends CrudRepository<DryFood, Long> {

}
