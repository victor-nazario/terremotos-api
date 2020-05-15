package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Query(value = "select * from payment ", nativeQuery = true)
    List<Payment> findAll();

    @Query(value="SELECT * FROM payment p inner join consumer c on p.consumer_id = c.id WHERE p.payment_id = :id", nativeQuery = true)
    Optional<Payment> findByPaymentId(@Param("id") Integer id);

    @Query(value="SELECT * FROM payment p inner join consumer c on p.consumer_id = c.id WHERE c.id = :id", nativeQuery = true)
    Optional<Payment> findByConsumerId(@Param("id") Integer id);

    @Query(value="SELECT * FROM payment p inner join consumer c on p.consumer_id = c.id WHERE p.purchase_total >= :purchaseTotal", nativeQuery = true)
    List<Payment> findByPurchaseTotalOver(@Param("purchaseTotal") Double purchaseTotal);

    @Query(value="SELECT * FROM payment p inner join consumer c on p.consumer_id = c.id WHERE p.purchase_total <= :purchaseTotal", nativeQuery = true)
    List<Payment> findByPurchaseTotalUnder(@Param("purchaseTotal") Double purchaseTotal);

    @Modifying
    @Query(value = "insert into payment (purchaseTotal, consumerId, paymentId) values (:purchaseTotal, :consumerId, :paymentId)",
            nativeQuery = true)
    void insertPayment(@Param("purchaseTotal") Double purchaseTotal,
                       @Param("consumerId") Long consumerId, @Param("paymentId") Long paymentId);

}
