package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Battery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface BatteryRepository extends CrudRepository<Battery, Long> {
    @Query(value = "select * from battery b inner join base_resource br on b.id = br.id;", nativeQuery = true)
    List<Battery> findAll();

    @Query(value = "select * from battery b inner join base_resource br on b.id = br.id where br.price <= :price ;"
            , nativeQuery = true)
    List<Battery> findByPriceUnder(@Param("price") Double price);



















    Optional<Battery> findById(Long id);

}
