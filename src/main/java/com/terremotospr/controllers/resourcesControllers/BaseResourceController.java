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
    public BaseResource findById(@PathVariable Long id) {
        return baseResourceService.findById(id);
    }

}
