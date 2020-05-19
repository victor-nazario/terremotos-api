package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.BatteryBean;
import com.terremotospr.database.entities.resourceEntities.Battery;
import com.terremotospr.services.resourceServices.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/battery")
@CrossOrigin("*")
public class BatteryController {

    @Autowired
    BatteryService batteryService;

    @GetMapping(value = "/fetch")
    public List<BatteryBean> fetchAvailableBattery(){
      return batteryService.fetchAllBattery();
    }

    @PostMapping(value = "/add")
    public boolean addBattery(@RequestBody BatteryBean bean){
        return batteryService.addBattery(bean);
    }

    @GetMapping(value = "/{id}")
    public Battery findPowerGenById(@PathVariable Long id) {
        return batteryService.findById(id);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<BatteryBean> findByPriceUnder(@PathVariable Double price) {
        return batteryService.findByPriceUnder(price);
    }

    @GetMapping(value = "/name/{name}")
    public List<BatteryBean> findByName(@PathVariable String name){ return batteryService.findByName(name); }

    @GetMapping(value = "/available")
    public List<BatteryBean> findAvailable(){ return batteryService.findAvailable(); }

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return batteryService.countAllResources();
    }
}
