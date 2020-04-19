package com.terremotospr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
public class HelloController {
        @GetMapping("/")
        public String hello(){
            return "Hello World";
        }
}
