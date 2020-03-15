package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.DryFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DryFoodRepository extends CrudRepository<DryFood, Long> {

}
