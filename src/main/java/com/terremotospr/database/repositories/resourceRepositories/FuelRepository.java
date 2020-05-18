package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Fuel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface FuelRepository extends CrudRepository<Fuel, Long> {

    @Query(value = "select * from fuel f inner join base_resource br on f.id = br.id", nativeQuery = true)
    List<Fuel> fetchAll();

    @Query(value = "select * from fuel f inner join base_resource br on f.id = br.id where f.id = :id"
            , nativeQuery = true)
    Fuel findById(@Param("id") Integer id);

    @Query(value = "select * from fuel f inner join base_resource br on f.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Fuel> findByName(@Param("name") String name);

    @Query(value = "select * from fuel f inner join base_resource br on f.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Fuel> findAvailable();


    @Modifying
    @Query(value = "insert into fuel (type, id) values (:type, :id)",
            nativeQuery = true)
    void insertFuel(@Param("type") String type, @Param("id") Long id);

}
