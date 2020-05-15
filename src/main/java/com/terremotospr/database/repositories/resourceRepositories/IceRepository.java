package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Ice;
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
public interface IceRepository extends CrudRepository<Ice,Long> {
    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id", nativeQuery = true)
    List<Ice> findAll();

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where ic.id = :id"
            , nativeQuery = true)
    Ice findById(@Param("id") Integer id);

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<Ice> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where br.price >= :price"
            , nativeQuery = true)
    List<Ice> findByPriceOver(@Param("price") Double price);

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<Ice> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Ice> findByName(@Param("name") String name);

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Ice> findAvailable();

    @Query(value = "select * from ice ic inner join base_resource br on ic.id = br.id where ic.size = :size"
            , nativeQuery = true)
    List<Ice> findBySize(@Param("size") Double size);

    @Modifying
    @Query(value = "insert into ice (size, id) values (:size, :id)",
            nativeQuery = true)
    void insertIce(@Param("size") Double size, @Param("id") Long id);
}