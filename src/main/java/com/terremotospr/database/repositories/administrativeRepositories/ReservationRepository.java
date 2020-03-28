package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Reservation;
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
