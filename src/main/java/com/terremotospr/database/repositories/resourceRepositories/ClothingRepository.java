package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.ClothesGender;
import com.terremotospr.beans.resourceBeans.ClothingType;
import com.terremotospr.database.entities.resourceEntities.Clothing;
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
public interface ClothingRepository extends CrudRepository<Clothing, Long> {

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id", nativeQuery = true)
    List<Clothing> findAll();

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where c.id = :id"
            , nativeQuery = true)
    Clothing findById(@Param("id") Integer id);

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<Clothing> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<Clothing> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Clothing> findByName(@Param("name") String name);

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where c.size = :size"
            , nativeQuery = true)
    List<Clothing> findBySize(@Param("size") String size);

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Clothing> findAvailable();

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where c.type = :type"
            , nativeQuery = true)
    List<Clothing> findByType(@Param("type") ClothingType type);

    @Query(value = "select * from clothing c inner join base_resource br on c.id = br.id where c.gender = :gender"
            , nativeQuery = true)
    List<Clothing> findByGender(@Param("gender") ClothesGender gender);
}
