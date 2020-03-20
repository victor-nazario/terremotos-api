package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.BabyFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BabyFoodRepository extends CrudRepository<BabyFood, Long> {
}