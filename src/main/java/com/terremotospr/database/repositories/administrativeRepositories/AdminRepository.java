package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.beans.resourceBeans.generatorType;
import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
    @Query(value = "select * from admin a inner join user u on a.id = u.id;", nativeQuery = true)
    List<Admin> findAll();

    @Query(value = "select * from admin a inner join user u on a.id = u.id where a.id = :id ;"
            , nativeQuery = true)
    Optional<Admin> findTheAdminId(@Param("id") Long id);
}
