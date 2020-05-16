package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.IceBean;
import com.terremotospr.database.entities.resourceEntities.Ice;
import com.terremotospr.services.resourceServices.IceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/ice")
@CrossOrigin("*")
public class IceController {

    @Autowired
    IceService iceService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody IceBean bean) {
        return iceService.addIce(bean);
    }

    @GetMapping(value = "/fetch") public List<IceBean> fetchAll(){ return iceService.fetchAllIce(); }

    @GetMapping(value = "/{id}")
    public Ice findIceById(@PathVariable int id){ return iceService.findById(id); }

    @GetMapping(value = "/price_under/{price}")
    public List<IceBean> findByPriceUnder(@PathVariable Double price){ return iceService.findByPriceUnder(price); }

    @GetMapping(value = "/price_over/{price}")
    public List<IceBean> findByPriceOver(@PathVariable Double price){ return iceService.findByPriceOver(price); }

    @GetMapping(value = "/brand/{brand}")
    public List<IceBean> findByBrand(@PathVariable String brand){ return iceService.findByBrand(brand); }

    @GetMapping(value = "/name/{name}")
    public List<IceBean> findByName(@PathVariable String name){ return iceService.findByName(name); }

    @GetMapping(value = "/available")
    public List<IceBean> findAvailable(){ return iceService.findAvailable(); }

    @GetMapping(value = "/size/{size}")
    public List<IceBean> findBySize(@PathVariable Double size){ return iceService.findBySize(size); }

}