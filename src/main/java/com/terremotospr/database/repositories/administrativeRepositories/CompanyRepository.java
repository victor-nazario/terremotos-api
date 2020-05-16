package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Company;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query(value="SELECT * FROM company co WHERE co.cid = :id", nativeQuery = true)
    Optional<Company> findById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM company co WHERE co.c_name = :name"
            , nativeQuery = true)
    List<Company> findByCompanyName(@Param("name") String name);

    @Query(value = "SELECT * FROM company co WHERE co.c_location = :location"
            , nativeQuery = true)
    List<Company> findByCompanyLocation(@Param("location") String location);

    @Modifying
    @Query(value = "insert into company (cName, cLocation) values (:cName, :cLocation)",
            nativeQuery = true)
    void insertCompany(@Param("cName") String cName, @Param("cLocation") String cLocation);

}
