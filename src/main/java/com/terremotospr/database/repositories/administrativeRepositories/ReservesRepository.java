package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Reserves;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Repository
public interface ReservesRepository extends CrudRepository<Reserves, Long> {
    @Query(value = "select * from reserves rs inner join reservation rv on rs.reservation_id = rv.id " +
            "inner join base_resource br on rs.resource_id = br.id", nativeQuery = true)
    List<Reserves> findAll();

    @Query(value = "select * from reserves rs inner join reservation rv on rs.reservation_id = rv.id " +
            "inner join base_resource br on rs.resource_id = br.id where rs.reservation_id = :reservationId"
            , nativeQuery = true)
    List<Reserves> findByReservationId(@Param("reservationId") Integer reservationId);

    @Query(value = "select * from reserves rs inner join reservation rv on rs.reservation_id = rv.id " +
            "inner join base_resource br on rs.resource_id = br.id where rs.resource_id = :resourceId"
            , nativeQuery = true)
    List<Reserves> findByResourceId(@Param("resourceId") Integer resourceId);

    @Query(value = "select * from reserves rs inner join reservation rv on rs.reservation_id = rv.id " +
            "inner join base_resource br on rs.resource_id = br.id where rs.rquantity >= :quantity"
            , nativeQuery = true)
    List<Reserves> findByReservedQuantityOver(@Param("quantity") Integer quantity);

    @Query(value = "select * from reserves rs inner join reservation rv on rs.reservation_id = rv.id " +
            "inner join base_resource br on rs.resource_id = br.id where rs.rquantity <= :quantity"
            , nativeQuery = true)
    List<Reserves> findByReservedQuantityUnder(@Param("quantity") Integer quantity);

}
