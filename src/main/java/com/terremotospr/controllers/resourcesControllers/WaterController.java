package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.TypeOfWater;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.services.resourceServices.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on March 12, 2020 - 9:30 PM
 *
 * @author Victor Nazario
 */

@RestController
@RequestMapping("/water")
@CrossOrigin("*")
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

    @GetMapping(value = "/{id}")
    public WaterBean findWaterById(@PathVariable Long id) {
        return waterService.findById(id);
    }

    @GetMapping(value = "/brand/{brand}")
    public List<WaterBean> findByBrand(@PathVariable String brand) {
        return waterService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<WaterBean> findByName(@PathVariable String name) {
        return waterService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<WaterBean> findByPriceUnder(@PathVariable Double price) {
        return waterService.findByPriceUnder(price);
    }

    @GetMapping(value = "/type/{type}")
    public List<WaterBean> findByWaterType(@PathVariable TypeOfWater type) {
        return waterService.findByWaterType(type);
    }

    @GetMapping(value = "/available")
    public List<WaterBean> findAvailable(){ return waterService.findAvailable(); }

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return waterService.countAllResources();
    }
}
