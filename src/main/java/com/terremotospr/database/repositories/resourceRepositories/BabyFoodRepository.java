package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.BabyFoodFlavor;
import com.terremotospr.beans.resourceBeans.FuelTypeGenerator;
import com.terremotospr.beans.resourceBeans.PowerGeneratorType;
import com.terremotospr.database.entities.resourceEntities.BabyFood;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */

@Repository
public interface BabyFoodRepository extends CrudRepository<BabyFood, Long> {
    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id", nativeQuery = true)
    List<BabyFood> findAll();

    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where bf.id = :id"
            , nativeQuery = true)
    BabyFood findById(@Param("id") Integer id);

    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<BabyFood> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<BabyFood> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<BabyFood> findByName(@Param("name") String name);

    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where bf.size = :size"
            , nativeQuery = true)
    List<BabyFood> findBySize(@Param("size") String size);

//    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where bf.flavor = :flavor"
//            , nativeQuery = true)
//    List<BabyFood> findByGeneratorType(@Param("flavor") generatorType flavor);

    @Query(value = "select * from baby_food bf inner join base_resource br on bf.id = br.id where br.available = true"
            , nativeQuery = true)
    List<BabyFood> findAvailable();

    @Modifying
    @Query(value = "insert into baby_food (size, flavor, id) values (:size, :flavor, :id)",
            nativeQuery = true)
    void insertBabyFood(@Param("size") String size, @Param("flavor") BabyFoodFlavor flavor,
                        @Param("id") Long id);
}
