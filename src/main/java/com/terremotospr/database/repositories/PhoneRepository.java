package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March 17, 2020 - 12:36PM
 *
 * @author Victor Nazario
 */
@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
