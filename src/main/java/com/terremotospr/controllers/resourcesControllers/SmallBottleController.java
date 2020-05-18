package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.SmallBottleBean;
import com.terremotospr.database.entities.resourceEntities.SmallBottle;
import com.terremotospr.services.resourceServices.SmallBottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/smallbottle")
public class SmallBottleController {

    @Autowired
    SmallBottleService smallBottleService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody SmallBottleBean bean) {
        return smallBottleService.addSmallBottle(bean);
    }

    @GetMapping(value = "/fetch")
    public List<SmallBottleBean> fetchAll(){ return smallBottleService.fetchAllSmallBottles(); }

    @GetMapping(value = "/{id}")
    public SmallBottle findSmallBottleWaterById(@PathVariable int id){ return smallBottleService.findById(id); }

    @GetMapping(value = "/price_under/{price}")
    public List<SmallBottleBean> findByPriceUnder(@PathVariable Double price){ return smallBottleService.findByPriceUnder(price); }

    @GetMapping(value = "/price_over/{price}")
    public List<SmallBottleBean> findByPriceOver(@PathVariable Double price){ return smallBottleService.findByPriceOver(price); }

    @GetMapping(value = "/brand/{brand}")
    public List<SmallBottleBean> findByBrand(@PathVariable String brand){ return smallBottleService.findByBrand(brand); }

    @GetMapping(value = "/name/{name}")
    public List<SmallBottleBean> findByName(@PathVariable String name){ return smallBottleService.findByName(name); }

    @GetMapping(value = "/available")
    public List<SmallBottleBean> findAvailable(){ return smallBottleService.findAvailable(); }

    @GetMapping(value = "/size/{size}")
    public List<SmallBottleBean> findBySize(@PathVariable Double size){ return smallBottleService.findBySize(size); }

    @GetMapping(value = "/type/{type}")
    public List<SmallBottleBean> findByType(@PathVariable String type){ return smallBottleService.findByType(type); }

    @GetMapping(value = "/potable")
    public List<SmallBottleBean> findPotable(){ return smallBottleService.findPotable(); }

    @GetMapping(value = "/packaged_quantity/{packagedQuantity}")
    public List<SmallBottleBean> findByPackagedQuantity(@PathVariable int packagedQuantity){return smallBottleService.findByPackagedQuantity(packagedQuantity); }

}
