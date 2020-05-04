package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Belongs;
import com.terremotospr.database.entities.administrativeEntities.Supplies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BelongsRepository extends CrudRepository<Belongs, Long> {
    @Query(value = "select * from belongs b inner join placed_order po on b.order_id = po.id " +
            "inner join base_resource br on b.resource_id = br.id", nativeQuery = true)
    List<Belongs> findAll();

    @Query(value = "select * from belongs b inner join placed_order po on b.order_id = po.id " +
            "inner join base_resource br on b.resource_id = br.id where b.order_id = :orderId"
            , nativeQuery = true)
    List<Belongs> findByOrderId(@Param("orderId") Integer orderId);

    @Query(value = "select * from belongs b inner join placed_order po on b.order_id = po.id " +
            "inner join base_resource br on b.resource_id = br.id where b.resource_id = :resourceId"
            , nativeQuery = true)
    List<Belongs> findByResourceId(@Param("resourceId") Integer resourceId);
}
