package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.TypeOfWater;
import com.terremotospr.database.entities.resourceEntities.Water;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created on March 12, 2020 - 9:13 PM
 *
 * @author Victor Nazario
 */
@Repository
public interface WaterRepository extends CrudRepository<Water, Long> {

    List<Water> findAll();

    Optional<Water> findById(Long id);

    List<Water>  findAllByPriceIsLessThan(Double price);

    List<Water> findAllByBrandEquals(String brand);

    List<Water> findAllByNameEquals(String name);

    List<Water> findAllByTypeEquals(TypeOfWater type);

    List<Water> findAllByAvailableIsTrue();
}
