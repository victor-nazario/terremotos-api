package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.PropaneBean;
import com.terremotospr.database.entities.resourceEntities.Propane;
import com.terremotospr.services.resourceServices.PropaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/propane")
@CrossOrigin("*")
public class PropaneController {

    @Autowired
    PropaneService propaneService;

    @PostMapping(value = "/add")
    public boolean addPropane(@RequestBody PropaneBean bean){
        return propaneService.addPropane(bean);
    }

    @GetMapping(value = "/fetch")
    public List<PropaneBean> fetchAll(){ return propaneService.fetchAllPropane(); }

    @GetMapping(value = "/{id}")
    public Propane findById(@PathVariable int id){ return propaneService.findById(id); }

    @GetMapping(value = "/name/{name}")
    public List<PropaneBean> findByName(@PathVariable String name){ return propaneService.findByName(name); }

    @GetMapping(value = "/available")
    public List<PropaneBean> findAvailable(){ return propaneService.findAvailable(); }

}
