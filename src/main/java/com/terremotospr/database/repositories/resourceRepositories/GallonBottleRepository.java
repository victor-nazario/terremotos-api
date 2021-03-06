package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.GallonBottle;
import org.springframework.data.jpa.repository.Modifying;
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
public interface GallonBottleRepository extends CrudRepository<GallonBottle, Long> {

    @Query(value = "select * from gallon_bottle" +
            " b inner join base_resource br on b.id = br.id where br.price <= :price ;"
            , nativeQuery = true)
    List<GallonBottle> findByPriceUnder(@Param("price") Double price);

    @Modifying
    @Query(value = "insert into gallon_bottle (w_id, id) values (:wid, :id)",
            nativeQuery = true)
    void insertGallonBottle(@Param("wid") Long wid, @Param("id") Long id);



















    Optional<GallonBottle> findById(Long id);

}
