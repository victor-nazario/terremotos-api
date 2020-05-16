package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.Pays;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Repository
public interface PaysRepository extends CrudRepository<Pays, Long> {
    @Query(value = "select * from pays ps inner join payment p on ps.payment_id = p.payment_id " +
            "inner join placed_order po on ps.order_id = po.id", nativeQuery = true)
    List<Pays> findAll();

    @Query(value = "select * from pays ps inner join payment p on ps.payment_id = p.payment_id " +
            "inner join placed_order po on ps.order_id = po.id where ps.payment_id = :paymentId", nativeQuery = true)
    List<Pays> findByPaymentId(@Param("paymentId") Integer paymentId);

    @Query(value = "select * from pays ps inner join payment p on ps.payment_id = p.payment_id " +
            "inner join placed_order po on ps.order_id = po.id where ps.order_id = :orderId", nativeQuery = true)
    List<Pays> findByOrderId(@Param("orderId") Integer orderId);

    @Modifying
    @Query(value = "insert into pays (payment_date, order_id, payment_id) values (:paymentDate, :orderId, :paymentId)",
            nativeQuery = true)
    void insertPays(@Param("paymentDate") Date paymentDate, @Param("orderId") Long orderId,
                    @Param("paymentId") Long paymentId);
}
