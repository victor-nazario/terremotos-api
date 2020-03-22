package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Tool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface ToolRepository extends CrudRepository<Tool, Long> {
}
