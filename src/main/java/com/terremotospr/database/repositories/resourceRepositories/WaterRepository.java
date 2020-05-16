package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.TypeOfWater;
import com.terremotospr.database.entities.resourceEntities.Water;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on March 12, 2020 - 9:13 PM
 *
 * @author Victor Nazario
 */
@Repository
public interface WaterRepository extends CrudRepository<Water, Long> {

    @Query(value = "select * from water w inner join base_resource br on w.id = br.id", nativeQuery = true)
    List<Water> fetchAll();

    @Query(value = "select * from water w inner join base_resource br on w.id = br.id where w.id = :id"
            , nativeQuery = true)
    Water findById(@Param("id") Integer id);

    @Query(value = "select * from water w inner join base_resource br on w.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Water> findByName(@Param("name") String name);

    @Query(value = "select * from water w inner join base_resource br on w.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Water> findAvailable();

    List<Water>  findAllByPriceIsLessThan(Double price);

    List<Water> findAllByBrandEquals(String brand);

    List<Water> findAllByNameEquals(String name);

    List<Water> findAllByTypeEquals(TypeOfWater type);

    List<Water> findAllByAvailableIsTrue();

    @Modifying
    @Query(value = "insert into water (type, packaged_quantity, potable, id) values (:type, :packaged_quantity, :potable, :type, :id)",
            nativeQuery = true)
    void insertWater(@Param("type") TypeOfWater type, @Param("packaged_quantity") Integer packaged_quantity,
                        @Param("potable") Boolean potable, @Param("id") Long id);
}
