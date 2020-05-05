package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    @Query(value = "select * from supplier s inner join user u on s.id = u.id", nativeQuery = true)
    List<Supplier> findAll();

    @Query(value = "select * from supplier s inner join user u on s.id = u.id where s.id = :id ;", nativeQuery = true)
    Optional<Supplier> findById(Long id);

    @Query(value = "select * from supplier s inner join user u on s.id = u.id where s.position = :position"
            , nativeQuery = true)
    List<Supplier> findByPosition(@Param("position") String position);

    @Query(value = "select * from supplier s inner join user u on s.id = u.id where u.city = :city"
            , nativeQuery = true)
    List<Supplier> findByCity(@Param("city") String city);

    @Query(value = "select * from supplier s inner join user u on s.id = u.id where u.region = :region"
            , nativeQuery = true)
    List<Supplier> findByRegion(@Param("region") String region);

}
