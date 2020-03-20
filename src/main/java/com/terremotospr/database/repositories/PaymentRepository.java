package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
