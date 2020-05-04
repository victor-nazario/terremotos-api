package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.DryFoodBean;
import com.terremotospr.beans.resourceBeans.MedicationBean;
import com.terremotospr.services.resourceServices.MedicationService;
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
@RequestMapping("/medications")
public class MedicationController {
    @Autowired
    MedicationService medicationService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody MedicationBean bean){
        return medicationService.addMedication(bean);
    }

    @GetMapping(value = "/fetch")
    public List<MedicationBean> fetchAll(){
        return medicationService.fetchAllMedication();
    }

    @GetMapping(value = "/brand/{brand}")
    public List<MedicationBean> findByBrand(@PathVariable String brand) {
        return medicationService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<MedicationBean> findByName(@PathVariable String name) {
        return medicationService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<MedicationBean> findByPriceUnder(@PathVariable Double price) {
        return medicationService.findByPriceUnder(price);
    }

    @GetMapping(value = "/size/{size}")
    public List<MedicationBean> findBySize(@PathVariable String size) {
        return medicationService.findBySize(size);
    }

    @GetMapping(value = "/available")
    public List<MedicationBean> findAvailable(){
        return medicationService.findAvailable();
    }


}
