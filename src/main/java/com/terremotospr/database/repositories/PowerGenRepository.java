package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.PowerGen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface PowerGenRepository extends CrudRepository<PowerGen, Long> {

}