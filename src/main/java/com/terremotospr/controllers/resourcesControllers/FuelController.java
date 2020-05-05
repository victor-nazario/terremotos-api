package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.FuelBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Fuel;
import com.terremotospr.services.resourceServices.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public List<FuelBean> fetchAvailableFuel(){
        return fuelService.fetchAllFuel();
    }

    @PostMapping(value = "/add")
    public boolean addFuel(@RequestBody FuelBean bean){
        return fuelService.addFuel(bean);
    }

    @GetMapping(value = "/{id}")
    public Fuel findById(@PathVariable Long id) {
        return fuelService.findById(id);
    }
}
