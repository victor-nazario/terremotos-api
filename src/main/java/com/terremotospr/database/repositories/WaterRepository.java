package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Water;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on March 12, 2020 - 9:13 PM
 *
 * @author Victor Nazario
 */
@Repository
public interface WaterRepository extends CrudRepository<Water, Long> {
}
