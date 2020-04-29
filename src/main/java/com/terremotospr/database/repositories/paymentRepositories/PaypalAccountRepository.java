package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.PaypalAccount;
import com.terremotospr.database.entities.resourceEntities.BabyFood;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface PaypalAccountRepository extends CrudRepository<PaypalAccount, Long> {

    @Query(value = "select * from paypal_account ppa inner join payment_method pm on ppa.pm_id = pm.pm_id", nativeQuery = true)
    List<PaypalAccount> findAll();

    @Query(value = "select * from paypal_account ppa inner join payment_method pm on ppa.pm_id = pm.pm_id where ppa.id = :id", nativeQuery = true)
    PaypalAccount findById(@Param("id") Integer id);

    @Query(value = "select * from paypal_account ppa inner join payment_method pm on ppa.pm_id = pm.pm_id where ppa.pm_id = :pm_id", nativeQuery = true)
    List<PaypalAccount> findByPmId(@Param("pm_id") Integer pm_id);

}
