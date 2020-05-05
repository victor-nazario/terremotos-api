package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Supplies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
