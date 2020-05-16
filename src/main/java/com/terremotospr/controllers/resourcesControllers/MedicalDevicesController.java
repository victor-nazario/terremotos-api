package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.MedicalDevicesBean;
import com.terremotospr.beans.resourceBeans.medicalDeviceType;
import com.terremotospr.database.entities.resourceEntities.MedicalDevices;
import com.terremotospr.services.resourceServices.MedicalDevicesService;
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
@RequestMapping("/medicaldevices")
@CrossOrigin("*")
public class MedicalDevicesController {

    @Autowired
    MedicalDevicesService medicalDevicesService;
    @PostMapping(value = "/add")
    public Boolean add(@RequestBody MedicalDevicesBean bean){
        return medicalDevicesService.addMedicalDevice(bean);
    }

    @GetMapping(value = "/fetch")
    public List<MedicalDevicesBean> fetchAll(){
        return medicalDevicesService.fetchAllMedicalDevices();
    }

    @GetMapping(value = "/{id}")
    public MedicalDevices findById(@PathVariable Integer id){
        return medicalDevicesService.findById(id);
    }

    @GetMapping(value = "/brand/{brand}")
    public List<MedicalDevicesBean> findByBrand(@PathVariable String brand) {
        return medicalDevicesService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<MedicalDevicesBean> findByName(@PathVariable String name) {
        return medicalDevicesService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<MedicalDevicesBean> findByPriceUnder(@PathVariable Double price) {
        return medicalDevicesService.findByPriceUnder(price);
    }

    @GetMapping(value = "/type/{type}")
    public List<MedicalDevicesBean> findByType(@PathVariable medicalDeviceType type) {
        return medicalDevicesService.findByType(type);
    }

    @GetMapping(value = "/available")
    public List<MedicalDevicesBean> findAvailable(){ return medicalDevicesService.findAvailable();}

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return medicalDevicesService.countAllResources();
    }
}
