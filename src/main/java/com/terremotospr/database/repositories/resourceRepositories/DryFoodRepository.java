package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.BabyFood;
import com.terremotospr.database.entities.resourceEntities.DryFood;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface DryFoodRepository extends CrudRepository<DryFood, Long> {
    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id", nativeQuery = true)
    List<DryFood> findAll();

    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where df.id = :id"
            , nativeQuery = true)
    DryFood findById(@Param("id") Integer id);

    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<DryFood> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<DryFood> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<DryFood> findByName(@Param("name") String name);

    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where df.size = :size"
            , nativeQuery = true)
    List<DryFood> findBySize(@Param("size") String size);

//    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where df.flavor = :flavor"
//            , nativeQuery = true)
//    List<DryFood> findByGeneratorType(@Param("flavor") generatorType flavor);

    @Query(value = "select * from dry_food df inner join base_resource br on df.id = br.id where br.available = true"
            , nativeQuery = true)
    List<DryFood> findAvailable();
}
