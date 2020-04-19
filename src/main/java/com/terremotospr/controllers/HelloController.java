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
            return "<h1>Terremotos-API</h1>" +
                    "<h3>Developed by:<br/>"+
                    "Víctor Nazario Morales<br/>" +
                    "Wilfredo Aponte Pomales<br/>" +
                    "Kiara Rodriguez Rojas<br/></h3>";
        }
}
