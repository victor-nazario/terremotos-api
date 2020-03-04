package com.terremotospr.repositories;

import com.terremotospr.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
