package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Cash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface CashRepository extends CrudRepository<Cash, Long> {
}
