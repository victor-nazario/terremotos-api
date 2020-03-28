package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.PaypalAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface PaypalAccountRepository extends CrudRepository<PaypalAccount, Long> {

}
