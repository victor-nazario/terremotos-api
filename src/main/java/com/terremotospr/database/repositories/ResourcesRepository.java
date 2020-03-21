package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.BaseResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourcesRepository extends CrudRepository<BaseResource, Long> {
}
