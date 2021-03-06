package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.FuelTypeGenerator;
import com.terremotospr.beans.resourceBeans.PowerGeneratorType;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
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
public interface PowerGenRepository extends CrudRepository<PowerGen, Long> {
    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id;", nativeQuery = true)
    List<PowerGen> findAll();

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where pg.id = :id ;"
            , nativeQuery = true)
    PowerGen findById(@Param("id") Integer id);

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where br.price <= :price ;"
            , nativeQuery = true)
    List<PowerGen> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where br.brand = :brand ;"
            , nativeQuery = true)
    List<PowerGen> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where br.name = :name ;"
            , nativeQuery = true)
    List<PowerGen> findByName(@Param("name") String name);

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where pg.power = :power ;"
            , nativeQuery = true)
    List<PowerGen> findByPower(@Param("power") String power);

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where pg.type = :type ;"
            , nativeQuery = true)
    List<PowerGen> findByGeneratorType(@Param("type") PowerGeneratorType type);

    @Query(value = "select * from power_gen pg inner join base_resource br on pg.id = br.id where br.available = true"
            , nativeQuery = true)
    List<PowerGen> findAvailable();

    @Modifying
    @Query(value = "insert into power_gen (fuel_type, power, type, id) values (:fuel_type, :power, :type, :id)",
            nativeQuery = true)
    void insertPowerGen(@Param("fuel_type") FuelTypeGenerator fuel_type, @Param("power") String power,
                        @Param("type") PowerGeneratorType type, @Param("id") Long id);
}
