package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
     
}
