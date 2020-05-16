package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.HeavyEquipment;
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
public interface HeavyEquipmentRepository extends CrudRepository<HeavyEquipment,Long> {
    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id", nativeQuery = true)
    List<HeavyEquipment> findAll();

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where he.id = :id"
            , nativeQuery = true)
   HeavyEquipment findById(@Param("id") Integer id);

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<HeavyEquipment> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where br.price >= :price"
            , nativeQuery = true)
    List<HeavyEquipment> findByPriceOver(@Param("price") Double price);

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<HeavyEquipment> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<HeavyEquipment> findByName(@Param("name") String name);

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where br.available = true"
            , nativeQuery = true)
    List<HeavyEquipment> findAvailable();

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where he.size = :size"
            , nativeQuery = true)
    List<HeavyEquipment> findBySize(@Param("size") Double size);

    @Query(value = "select * from heavy_equipment he inner join base_resource br on he.id = br.id where he.type = :type"
            , nativeQuery = true)
    List<HeavyEquipment> findByType(@Param("type") String type);

    @Modifying
    @Query(value = "insert into heavy_equipment (size, type, id) values (:size, :type, :id)",
            nativeQuery = true)
    void insertHeavyEquip(@Param("size") Double size,
                        @Param("type") String type, @Param("id") Long id);

}
