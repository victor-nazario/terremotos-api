package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.BaseResourceBean;
import com.terremotospr.services.resourceServices.BaseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/resource")
public class BaseResourceController {
    @Autowired
    BaseResourceService baseResourceService;

    @GetMapping(value = "/fetch")
    public List<BaseResourceBean> fetchAll(){
        return baseResourceService.fetchAllBaseResource();
    }

    @GetMapping(value = "/available")
    public List<BaseResourceBean> findAvailable() { return baseResourceService.findAvailable();}

    @GetMapping(value = "/name/{name}")
    public List<BaseResourceBean> findByName(@PathVariable String name) {
        return baseResourceService.findByName(name);
    }

}
