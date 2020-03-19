package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

}
