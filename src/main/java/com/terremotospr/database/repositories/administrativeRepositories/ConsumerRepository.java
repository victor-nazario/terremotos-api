package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Consumer;
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
public interface ConsumerRepository extends CrudRepository<Consumer,Long> {
    @Query(value = "SELECT * FROM consumer c INNER JOIN user u on c.id = u.id;", nativeQuery = true)
    List<Consumer> findAll();

    @Query(value="SELECT * FROM consumer c INNER JOIN user u on c.id = u.id WHERE c.id = :id", nativeQuery = true)
    Optional<Consumer> findById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM consumer c INNER JOIN user u on c.id = u.id WHERE u.city = :city"
            , nativeQuery = true)
    List<Consumer> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM consumer c INNER JOIN  user u on c.id = u.id WHERE u.region = :region"
            , nativeQuery = true)
    List<Consumer> findByRegion(@Param("region") String region);

    @Query(value = "SELECT * FROM consumer c INNER JOIN  user u on c.id = u.id WHERE c.type = :type"
            , nativeQuery = true)
    List<Consumer> findByType(@Param("type") String type);

    @Modifying
    @Query(value = "insert into consumer (type, id) values (:type, :id)",
            nativeQuery = true)
    void insertConsumer(@Param("type") String type, @Param("id") Long id);


    Optional<Consumer> findConsumerById(Long id);

}