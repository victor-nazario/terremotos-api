package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.DieselBean;
import com.terremotospr.database.entities.resourceEntities.Diesel;
import com.terremotospr.services.resourceServices.DieselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/diesel")
@CrossOrigin("*")
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
    public Diesel findById(@PathVariable Long id) {
        return dieselService.findById(id);
    }

    @GetMapping(value = "/name/{name}")
    public List<DieselBean> findByName(@PathVariable String name){ return dieselService.findByName(name); }

    @GetMapping(value = "/available")
    public List<DieselBean> findAvailable(){ return dieselService.findAvailable(); }
}
