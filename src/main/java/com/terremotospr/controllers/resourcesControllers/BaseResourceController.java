package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.BaseResourceBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.BaseResource;
import com.terremotospr.services.resourceServices.BaseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/resource")
@CrossOrigin("*")
public class BaseResourceController {
    @Autowired
    BaseResourceService baseResourceService;

    @GetMapping(value = "/fetch")
    public List<BaseResourceBean> fetchAll(){
        return baseResourceService.fetchAllBaseResource();
    }

    @GetMapping(value = "/{id}")
    public BaseResourceBean findById(@PathVariable Long id) {
        return baseResourceService.findById(id);
    }

    @GetMapping(value = "/available")
    public List<BaseResourceBean> fetchAvailable(){
        return baseResourceService.fetchAvailable();
    }

    @GetMapping(value = "name/{name}")
    public List<BaseResourceBean> findById(@PathVariable String name) {
        return baseResourceService.findByName(name);
    }

    @GetMapping(value = "/lastDay")
    public List<BaseResourceBean> lastDay() {
        return baseResourceService.fetchByDay(false);
    }

    @GetMapping(value = "/lastWeek")
    public List<BaseResourceBean> lastWeek() {
        return baseResourceService.fetchByDay(true);
    }

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return baseResourceService.countAllResources();
    }

    @GetMapping(value = "/count/available")
    public Long countAvailable() {
        return baseResourceService.countAllByAvailable();
    }

}
