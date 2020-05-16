package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.CannedFoodBean;
import com.terremotospr.beans.resourceBeans.TypeOfCannedFood;
import com.terremotospr.database.entities.resourceEntities.CannedFood;
import com.terremotospr.services.resourceServices.CannedFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/cannedfood")
@CrossOrigin("*")
public class CannedFoodController {

    @Autowired
    CannedFoodService cannedFoodService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody CannedFoodBean bean) {
        return cannedFoodService.addCannedFood(bean);
    }

    @GetMapping(value = "/fetch")
    public List<CannedFoodBean> fetchAll(){ return cannedFoodService.fetchAllCannedFood(); }

    @GetMapping(value = "/{id}")
    public CannedFood findCannedFoodById(@PathVariable int id){ return cannedFoodService.findById(id); }

    @GetMapping(value = "/price_under/{price}")
    public List<CannedFoodBean> findByPriceUnder(@PathVariable Double price){ return cannedFoodService.findByPriceUnder(price); }

    @GetMapping(value = "/price_over/{price}")
    public List<CannedFoodBean> findByPriceOver(@PathVariable Double price){ return cannedFoodService.findByPriceOver(price); }

    @GetMapping(value = "/brand/{brand}")
    public List<CannedFoodBean> findByBrand(@PathVariable String brand){ return cannedFoodService.findByBrand(brand); }

    @GetMapping(value = "/name/{name}")
    public List<CannedFoodBean> findByName(@PathVariable String name){ return cannedFoodService.findByName(name); }

    @GetMapping(value = "/available")
    public List<CannedFoodBean> findAvailable(){ return cannedFoodService.findAvailable(); }

    @GetMapping(value = "/size/{size}")
    public List<CannedFoodBean> findBySize(@PathVariable Double size){ return cannedFoodService.findBySize(size); }

    @GetMapping(value = "/type/{type}")
    public List<CannedFoodBean> findByType(@PathVariable String type){ return cannedFoodService.findByType(type); }

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return cannedFoodService.countAllResources();
    }

}