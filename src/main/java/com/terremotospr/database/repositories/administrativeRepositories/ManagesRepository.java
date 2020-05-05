package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.entities.administrativeEntities.Manages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
@Repository
public interface ManagesRepository extends CrudRepository<Manages, Long> {
    Set<Manages> findAllByAdminEquals(Admin admin);
}
