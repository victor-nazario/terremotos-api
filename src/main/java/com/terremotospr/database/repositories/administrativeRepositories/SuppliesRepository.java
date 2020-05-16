package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Supplies;
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
public interface SuppliesRepository extends CrudRepository<Supplies, Long> {
    @Query(value = "select * from supplies ss inner join supplier s on ss.supplier_id = s.id " +
            "inner join base_resource br on ss.resource_id = br.id", nativeQuery = true)
    List<Supplies> findAll();

    @Query(value = "select * from supplies ss inner join supplier s on ss.supplier_id = s.id " +
            "inner join base_resource br on ss.resource_id = br.id where ss.supplier_id = :supplierId"
            , nativeQuery = true)
    List<Supplies> findBySupplierId(@Param("supplierId") Integer supplierId);

    @Query(value = "select * from supplies ss inner join supplier s on ss.supplier_id = s.id " +
            "inner join base_resource br on ss.resource_id = br.id where ss.resource_id = :resourceId"
            , nativeQuery = true)
    List<Supplies> findByResourceId(@Param("resourceId") Integer resourceId);

    @Modifying
    @Query(value = "insert into supplies (resource_id, stock, supplier_id) values (:resource_id, :stock, :supplier_id)",
            nativeQuery = true)
    void insertSupplies(@Param("resource_id") Long resource_id, @Param("stock") Long stock,
                        @Param("supplier_id") Long supplier_id);
}
