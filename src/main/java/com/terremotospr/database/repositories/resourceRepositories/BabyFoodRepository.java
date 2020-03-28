package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.BabyFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BabyFoodRepository extends CrudRepository<BabyFood, Long> {
}
