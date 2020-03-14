package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "select * from  people", nativeQuery = true)
    public List<Person> personList(String people);
}
