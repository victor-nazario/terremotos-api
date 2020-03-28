package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.Pays;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Repository
public interface PaysRepository extends CrudRepository<Pays, Long> {
}
