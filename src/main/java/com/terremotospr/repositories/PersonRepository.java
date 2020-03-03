package com.terremotospr.repositories;

import com.terremotospr.entities.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
