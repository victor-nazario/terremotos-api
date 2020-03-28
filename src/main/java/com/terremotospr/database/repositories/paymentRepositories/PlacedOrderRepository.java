package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.PlacedOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface PlacedOrderRepository extends CrudRepository<PlacedOrder, Long> {
}
