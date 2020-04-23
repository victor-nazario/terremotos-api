package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.services.resourceServices.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/fetch")
    public List<WaterBean> fetchAvailableWater(){
      return waterService.fetchAllWater();
    }

    @PostMapping(value = "/add")
    public boolean addWater(@RequestBody WaterBean bean){
        return waterService.addWater(bean);
    }
}
