package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
