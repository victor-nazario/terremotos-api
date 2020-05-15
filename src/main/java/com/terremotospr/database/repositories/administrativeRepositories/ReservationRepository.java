package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Modifying
    @Query(value = "insert into reservation (consumer_id, date, id) values (:consumer_id, :date, :id)",
            nativeQuery = true)
    void insertReservation(@Param("consumer_id") Long consumer_id, @Param("date") Date date,
                        @Param("id") Long id);
}
