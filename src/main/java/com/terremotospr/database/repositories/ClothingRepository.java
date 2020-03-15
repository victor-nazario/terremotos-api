package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Clothing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte
 */

@Repository
public interface ClothingRepository extends CrudRepository<Clothing, Long> {
}
