package com.terremotospr.controllers;

import com.terremotospr.repositories.dummyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/dummy")
public class dummycontroller {

    @Autowired
    com.terremotospr.repositories.dummyrepo dummyrepo;

    @GetMapping(value = "/dummy")
    public String dummyMethod(){
        return null;
    }
}
