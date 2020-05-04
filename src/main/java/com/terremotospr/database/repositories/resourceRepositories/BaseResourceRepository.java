package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.BaseResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BaseResourceRepository extends CrudRepository<BaseResource, Long> {
    @Query(value = "select * from base_resource", nativeQuery = true)
    List<BaseResource> findAll();

    @Query(value = "select * from base_resource where id = :id", nativeQuery = true)
    BaseResource findById(@Param("id") Integer id);

    @Query(value = "select * from base_resource where name = :name", nativeQuery = true)
    List<BaseResource> findByName(@Param("name") String name);

    @Query(value = "select * from base_resource where available = true", nativeQuery = true)
    List<BaseResource> findAvailable();
}
