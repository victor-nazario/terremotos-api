package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created on March 17, 2020 - 12:58 AM
 *
 * @author Victor Nazario
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Query(value = "SELECT * FROM admin", nativeQuery = true)
    List<Admin> findAll();
}
