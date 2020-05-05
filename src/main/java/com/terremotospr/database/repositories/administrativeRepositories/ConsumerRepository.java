package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.beans.administrativeBeans.ConsumerType;
import com.terremotospr.database.entities.administrativeEntities.Consumer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.List;
import java.util.Optional;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer,Long> {
    @Query(value = "SELECT * FROM consumer c inner join user u on c.id = u.id;", nativeQuery = true)
    List<Consumer> findAll();

    Optional<Consumer> findConsumerById(Long id);

    @Query(value="SELECT * FROM consumer c inner join user u on c.id = u.id WHERE c.id = :id", nativeQuery = true)
    Optional<Consumer> findById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM consumer c INNER JOIN user u on c.id = u.id WHERE u.city = :city"
            , nativeQuery = true)
    List<Consumer> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM consumer c INNER JOIN user u on c.id = u.id WHERE u.region = :region"
            , nativeQuery = true)
    List<Consumer> findByRegion(@Param("region") String region);

    @Query(value = "SELECT * FROM consumer c INNER JOIN user u on c.id = u.id WHERE c.type = :type"
            , nativeQuery = true)
    List<Consumer> findByType(@Param("type") ConsumerType type);

}