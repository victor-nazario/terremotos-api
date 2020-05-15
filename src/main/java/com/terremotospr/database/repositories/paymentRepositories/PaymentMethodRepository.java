package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.PaymentMethod;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {

    @Query(value = "select * from payment_method pm inner join consumer c on pm.id = c.id " +
            "inner join cash ca on pm.pm_id = ca.pm_id " +
            "inner join card cr on pm.pm_id = cr.pm_id " +
            "inner join paypal_account pa on pm.pm_id = pa.pm_id", nativeQuery = true)
    List<PaymentMethod> findAllPm();

    @Modifying
    @Query(value = "insert into payment_method (id) values (:consumerId)",
            nativeQuery = true)
    void insertPaymentMethod( @Param("consumerId") Long consumerId);
     
}
