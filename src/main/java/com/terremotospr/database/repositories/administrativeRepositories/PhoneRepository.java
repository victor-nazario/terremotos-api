package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Phone;
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
