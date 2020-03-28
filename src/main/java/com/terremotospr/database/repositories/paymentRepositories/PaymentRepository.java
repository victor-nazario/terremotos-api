package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
