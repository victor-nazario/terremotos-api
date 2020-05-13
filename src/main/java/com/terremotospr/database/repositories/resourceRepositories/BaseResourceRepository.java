package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.BaseResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BaseResourceRepository extends CrudRepository<BaseResource, Long> {
        @Query(value = "SELECT * FROM base_resource", nativeQuery = true)
        List<BaseResource> findAllResources();

        @Query(value = "SELECT * FROM base_resource where id = :id", nativeQuery = true)
        Optional<BaseResource> findResourceById(Long id);

        List<BaseResource> findAllByAvailableIsTrueOrderByName();

        List<BaseResource> findAllByNameEquals(String name);
}
