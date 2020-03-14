package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.WaterBean;
import com.terremotospr.services.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created on March 12, 2020 - 9:30 PM
 *
 * @author Victor Nazario
 */

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    WaterService waterService;

    @GetMapping(value = "/available")
    public Object fetchAvailableWater() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/waterResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
