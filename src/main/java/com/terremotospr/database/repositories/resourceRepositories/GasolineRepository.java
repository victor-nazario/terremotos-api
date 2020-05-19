package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Gasoline;
import org.springframework.data.jpa.repository.Modifying;
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
    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id", nativeQuery = true)
    List<Gasoline> findAll();

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and g.id = :id"
            , nativeQuery = true)
    Gasoline findById(@Param("id") Integer id);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and br.price <= :price"
            , nativeQuery = true)
    List<Gasoline> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id  and br.price >= :price"
            , nativeQuery = true)
    List<Gasoline> findByPriceOver(@Param("price") Double price);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and br.brand = :brand"
            , nativeQuery = true)
    List<Gasoline> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and br.name = :name"
            , nativeQuery = true)
    List<Gasoline> findByName(@Param("name") String name);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and br.available = true"
            , nativeQuery = true)
    List<Gasoline> findAvailable();

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and  g.size = :size"
            , nativeQuery = true)
    List<Gasoline> findBySize(@Param("size") Double size);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and g.octane = :octane"
            , nativeQuery = true)
    List<Gasoline> findByOctane(@Param("octane") Double octane);

    @Query(value = "select * from gasoline g inner join base_resource br inner join fuel f " +
            "where g.id = br.id and g.id = f.id and g.gasoline_type = :gasolineType"
            , nativeQuery = true)
    List<Gasoline> findByType(@Param("gasolineType") String gasolineType);

    @Modifying
    @Query(value = "insert into gasoline (gasoline_type, octane, size, id) values (:gasolineType, :octane, :size, :id)",
            nativeQuery = true)
    void insertGasoline(@Param("gasolineType") String gasolineType, @Param("octane") Double octane,
                        @Param("size") Double size, @Param("id") Long id);
}
