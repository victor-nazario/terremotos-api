package com.terremotospr.repositories;

import com.terremotospr.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March 7, 2020 - 9:17 PM
 *
 * @author Victor Nazario
 */

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
