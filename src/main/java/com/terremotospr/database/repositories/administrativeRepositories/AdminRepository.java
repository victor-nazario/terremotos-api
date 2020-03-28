package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on March 17, 2020 - 12:58 AM
 *
 * @author Victor Nazario
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
