package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {

    @Query(value = "SELECT * FROM company co", nativeQuery = true)
    List<Company> findAll();

    @Query(value="SELECT * FROM company co WHERE co.id = :id", nativeQuery = true)
    Optional<Company> findById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM company co WHERE co.cName = :name"
            , nativeQuery = true)
    List<Company> findByCompanyName(@Param("name") String name);

    @Query(value = "SELECT * FROM company co WHERE u.cLocation = :location"
            , nativeQuery = true)
    List<Company> findByCompanyLocation(@Param("location") String location);

}
