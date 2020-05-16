package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.GasolineBean;
import com.terremotospr.database.entities.resourceEntities.Gasoline;
import com.terremotospr.services.resourceServices.GasolineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@RestController
@RequestMapping(value = "/gasoline")
public class GasolineController {

    @Autowired
    GasolineService gasolineService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody GasolineBean bean) {
        return gasolineService.addGasoline(bean);
    }

    @GetMapping(value = "/fetch")
    public List<GasolineBean> fetchAll(){ return gasolineService.fetchAllGasoline(); }

    @GetMapping(value = "/{id}")
    public Gasoline findGasolineById(@PathVariable int id){ return gasolineService.findById(id); }

    @GetMapping(value = "/price_under/{price}")
    public List<GasolineBean> findByPriceUnder(@PathVariable Double price){ return gasolineService.findByPriceUnder(price); }

    @GetMapping(value = "/price_over/{price}")
    public List<GasolineBean> findByPriceOver(@PathVariable Double price){ return gasolineService.findByPriceOver(price); }

    @GetMapping(value = "/brand/{brand}")
    public List<GasolineBean> findByBrand(@PathVariable String brand){ return gasolineService.findByBrand(brand); }

    @GetMapping(value = "/name/{name}")
    public List<GasolineBean> findByName(@PathVariable String name){ return gasolineService.findByName(name); }

    @GetMapping(value = "/available")
    public List<GasolineBean> findAvailable(){ return gasolineService.findAvailable(); }

    @GetMapping(value = "/size/{size}")
    public List<GasolineBean> findBySize(@PathVariable Double size){ return gasolineService.findBySize(size); }

    @GetMapping(value = "/octane/{octane}")
    public List<GasolineBean> findByOctane(@PathVariable Double octane){ return gasolineService.findByOctane(octane); }

    @GetMapping(value = "/type/{type}")
    public List<GasolineBean> findByType(@PathVariable String type){ return gasolineService.findByGasolineType(type); }

}