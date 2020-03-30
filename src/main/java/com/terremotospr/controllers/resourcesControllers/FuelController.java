package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.FuelBean;
import com.terremotospr.services.resourceServices.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/fuel")
public class FuelController{
    @Autowired
    FuelService fuelService;

    @GetMapping(value = "/fetch")
    public Object fetchAvailableFuel() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/fuelResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

    @PostMapping(value = "/add")
    public boolean addFuel(@RequestBody FuelBean bean){
        return fuelService.addFuel(bean);
    }
}
