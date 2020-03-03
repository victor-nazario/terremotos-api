package com.terremotospr.services;

import com.terremotospr.entities.Person;
import com.terremotospr.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);

     }
}
