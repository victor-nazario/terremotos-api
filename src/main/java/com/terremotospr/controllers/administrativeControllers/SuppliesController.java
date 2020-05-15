package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.SuppliesBean;
import com.terremotospr.database.entities.resourceEntities.Clothing;
import com.terremotospr.services.administrativeServices.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/supplies")
@CrossOrigin("*")
public class SuppliesController {

    @Autowired
    SuppliesService suppliesService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody SuppliesBean bean){
        return suppliesService.addSupplies(bean);
    }

    @GetMapping(value = "/fetch")
    public List<SuppliesBean> fetchAll(){
        return suppliesService.fetchAllSupplies();
    }

    @GetMapping(value = "/supplier/{id}")
    public List<SuppliesBean> findBySupplierId(@PathVariable Integer id) { return suppliesService.findBySupplierId(id); }

    @GetMapping(value = "/resource/{id}")
    public List<SuppliesBean> findByResourceId(@PathVariable Integer id) { return suppliesService.findByResourceId(id); }

}
