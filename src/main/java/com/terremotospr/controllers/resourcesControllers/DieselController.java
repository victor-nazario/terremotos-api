package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.DieselBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Diesel;
import com.terremotospr.services.resourceServices.DieselService;
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
@RequestMapping("/diesel")
public class DieselController {
    @Autowired
    DieselService dieselService;

    @GetMapping(value = "/fetch")
    public List<DieselBean> fetchAvailableDiesel() {
        return dieselService.fetchAllDiesel();
    }

    @PostMapping(value = "/add")
    public boolean addDiesel(@RequestBody DieselBean bean){
        return dieselService.addDiesel(bean);
    }

    @GetMapping(value = "/{id}")
    public Diesel findWaterById(@PathVariable Long id) {
        return dieselService.findById(id);
    }
}
