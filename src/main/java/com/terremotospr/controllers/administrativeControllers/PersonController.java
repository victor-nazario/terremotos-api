package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.PersonBean;
import com.terremotospr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on  3 March, 2020
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/fetchAll")
    public List<PersonBean> fetchAll(){
        return personService.fetchAllPerson();
    }

    @GetMapping(value = "/fetchById")
    public PersonBean fetchById(@RequestParam(value = "id") Long id){
        return personService.fetchById(id);
    }
}
