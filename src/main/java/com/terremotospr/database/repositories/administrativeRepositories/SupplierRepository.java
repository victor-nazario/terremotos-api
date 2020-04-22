package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.entities.administrativeEntities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    @Query(value = "SELECT * FROM supplier", nativeQuery = true)
    List<Supplier> findAll();

    @Query(value="SELECT * FROM supplier WHERE id = :id", nativeQuery = true)
    Supplier findById(@Param("id") Integer id);
}
