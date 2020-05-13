package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.PlacedOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface PlacedOrderRepository extends CrudRepository<PlacedOrder, Long> {
    @Query(value = "select * from placed_order", nativeQuery = true)
    List<PlacedOrder> findAll();

    @Query(value = "select * from placed_order po po.id = :id;"
            , nativeQuery = true)
    Optional<PlacedOrder> findById(@Param("id") Long id);

    @Query(value = "select * from placed_order a where a.date <= :finalDateTime AND a.date >= :baseDateTime", nativeQuery = true)
    List<PlacedOrder> findAllWithCreationDateTimeBefore(
            @Param("baseDateTime") Date baseDateTime,  @Param("finalDateTime") Date finalDateTime);
}
