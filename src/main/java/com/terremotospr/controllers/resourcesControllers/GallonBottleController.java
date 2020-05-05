package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.BatteryBean;
import com.terremotospr.beans.resourceBeans.GallonBottleBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Battery;
import com.terremotospr.database.entities.resourceEntities.GallonBottle;
import com.terremotospr.services.resourceServices.GallonBottleService;
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
@RequestMapping("/gallon")
public class GallonBottleController {
    @Autowired
    GallonBottleService gallonBottleService;

    @GetMapping(value = "/fetch")
    public List<GallonBottleBean> fetchAvailableGallon(){
        return gallonBottleService.fetchAllGallon();
    }

    @PostMapping(value = "/add")
    public boolean addGallon(@RequestBody GallonBottleBean bean){
        return gallonBottleService.addGallon(bean);
    }

    @GetMapping(value = "/{id}")
    public GallonBottle findPowerGenById(@PathVariable Long id) {
        return gallonBottleService.findById(id);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<GallonBottleBean> findByPriceUnder(@PathVariable Double price) {
        return gallonBottleService.findByPriceUnder(price);
    }
}
