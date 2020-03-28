package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.resourceEntities.BaseResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourcesRepository extends CrudRepository<BaseResource, Long> {
}
