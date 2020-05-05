package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.CannedFood;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface CannedFoodRepository extends CrudRepository<CannedFood,Long> {
    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id", nativeQuery = true)
    List<CannedFood> findAll();

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where cf.id = :id"
            , nativeQuery = true)
    CannedFood findById(@Param("id") Integer id);

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<CannedFood> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where br.price >= :price"
            , nativeQuery = true)
    List<CannedFood> findByPriceOver(@Param("price") Double price);

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<CannedFood> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<CannedFood> findByName(@Param("name") String name);

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where br.available = true"
            , nativeQuery = true)
    List<CannedFood> findAvailable();

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where cf.size = :size"
            , nativeQuery = true)
    List<CannedFood> findBySize(@Param("size") Double size);

    @Query(value = "select * from canned_food cf inner join base_resource br on cf.id = br.id where cf.type = :type"
            , nativeQuery = true)
    List<CannedFood> findByType(@Param("type") String type);
}