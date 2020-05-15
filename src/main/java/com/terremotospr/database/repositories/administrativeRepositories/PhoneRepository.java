package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created on March 17, 2020 - 12:36PM
 *
 * @author Victor Nazario
 */
@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
    @Modifying
    @Query(value = "insert into phone (phone_id, phone, id) values (:phone_id, :phone, :id)",
            nativeQuery = true)
    void insertPhone(@Param("phone_id") Long phone_id, @Param("phone") String phone,
                        @Param("id") Long id);
}
