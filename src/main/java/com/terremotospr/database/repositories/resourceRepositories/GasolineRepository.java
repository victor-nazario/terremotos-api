package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.TypeOfGasoline;
import com.terremotospr.database.entities.resourceEntities.Gasoline;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */
@Repository
public interface GasolineRepository extends CrudRepository<Gasoline, Long> {
    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id", nativeQuery = true)
    List<Gasoline> findAll();

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where g.id = :id"
            , nativeQuery = true)
    Gasoline findById(@Param("id") Integer id);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<Gasoline> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where br.price => :price"
            , nativeQuery = true)
    List<Gasoline> findByPriceOver(@Param("price") Double price);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<Gasoline> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Gasoline> findByName(@Param("name") String name);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Gasoline> findAvailable();

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where g.size = :size"
            , nativeQuery = true)
    List<Gasoline> findBySize(@Param("size") Double size);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where g.octane = :octane"
            , nativeQuery = true)
    List<Gasoline> findByOctane(@Param("octane") Double octane);

    @Query(value = "select * from gasoline g inner join base_resource br on g.id = br.id where g.type = :type"
            , nativeQuery = true)
    List<Gasoline> findByType(@Param("type") TypeOfGasoline type);
}
