package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.BatteryBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.services.resourceServices.BatteryService;
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
@RequestMapping("/battery")
public class BatteryController {

    @Autowired
    BatteryService batteryService;

    @GetMapping(value = "/fetch")
    public Object fetchAvailableBattery() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/batteryResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

    @PostMapping(value = "/add")
    public boolean addBattery(@RequestBody BatteryBean bean){
        return batteryService.addBattery(bean);
    }
}
