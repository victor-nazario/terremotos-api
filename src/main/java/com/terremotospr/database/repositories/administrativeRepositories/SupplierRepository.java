package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    @Query(value = "SELECT * FROM supplier s INNER JOIN user u on s.id = u.id;", nativeQuery = true)
    List<Supplier> findAll();

    @Query(value="SELECT * FROM supplier s INNER JOINuser u on s.id = u.id WHERE s.id = :id", nativeQuery = true)
    Supplier findById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM supplier s INNER JOIN user u on s.id = u.id WHERE s.position = :position"
            , nativeQuery = true)
    List<Supplier> findByPosition(@Param("position") String position);

    @Query(value = "SELECT * FROM supplier s INNER JOIN user u on s.id = u.id WHERE u.city = :city"
            , nativeQuery = true)
    List<Supplier> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM supplier s INNER JOIN user u on s.id = u.id WHERE u.region = :region"
            , nativeQuery = true)
    List<Supplier> findByRegion(@Param("region") String region);
}
