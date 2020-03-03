package com.terremotospr.controllers;

import com.terremotospr.entities.Person;
import com.terremotospr.repositories.PersonRepository;
import com.terremotospr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/fetchById")
    public Optional<Person> fetchById(@RequestParam(value = "id") Long id){
        return personService.findById(id);
    }
}
