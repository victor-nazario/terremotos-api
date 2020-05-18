package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.SmallBottle;
import org.springframework.data.jpa.repository.Modifying;
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
public interface SmallBottleRepository extends CrudRepository<SmallBottle,Long> {
    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id", nativeQuery = true)
    List<SmallBottle> findAll();

    @Query(value ="select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and sb.id = :id "
            , nativeQuery = true)
    SmallBottle findById(@Param("id") Integer id);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and br.price <= :price"
            , nativeQuery = true)
    List<SmallBottle> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and br.price >= :price"
            , nativeQuery = true)
    List<SmallBottle> findByPriceOver(@Param("price") Double price);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and br.brand = :brand"
            , nativeQuery = true)
    List<SmallBottle> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and br.name = :name"
            , nativeQuery = true)
    List<SmallBottle> findByName(@Param("name") String name);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and br.available = true"
            , nativeQuery = true)
    List<SmallBottle> findAvailable();

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and sb.size = :size"
            , nativeQuery = true)
    List<SmallBottle> findBySize(@Param("size") Double size);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and w.type = :type"
            , nativeQuery = true)
    List<SmallBottle> findByType(@Param("type") String type);

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and w.potable = true"
            , nativeQuery = true)
    List<SmallBottle> findPotable();

    @Query(value = "select * from small_bottle sb inner join base_resource br inner join water w " +
            "where sb.id = br.id and sb.id = w.id and w.packaged_quantity = :packagedQuantity"
            , nativeQuery = true)
    List<SmallBottle> findByPackagedQuantity(@Param("packagedQuantity") int packagedQuantity);

    @Modifying
    @Query(value = "insert into small_bottle (size, id) values (:size, :id)",
            nativeQuery = true)
    void insertSmallBottle(@Param("size") Double size, @Param("id") Long id);
}

