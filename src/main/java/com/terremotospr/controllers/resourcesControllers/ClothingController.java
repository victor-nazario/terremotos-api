package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.ClothesGender;
import com.terremotospr.beans.resourceBeans.ClothingBean;
import com.terremotospr.beans.resourceBeans.ClothingType;
import com.terremotospr.beans.resourceBeans.DryFoodBean;
import com.terremotospr.database.entities.resourceEntities.Clothing;
import com.terremotospr.services.resourceServices.ClothingService;
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
@RequestMapping("/clothing")
@CrossOrigin("*")
public class ClothingController {
    @Autowired
    ClothingService clothingService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ClothingBean bean){
        return clothingService.addClothing(bean);
    }

    @GetMapping(value = "/fetch")
    public List<ClothingBean> fetchAll(){
        return clothingService.fetchAllClothing();
    }

    @GetMapping(value = "/available")
    public List<ClothingBean> findAvailable() { return clothingService.findAvailable();}

    @GetMapping(value = "/brand/{brand}")
    public List<ClothingBean> findByBrand(@PathVariable String brand) {
        return clothingService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<ClothingBean> findByName(@PathVariable String name) {
        return clothingService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<ClothingBean> findByPriceUnder(@PathVariable Double price) {
        return clothingService.findByPriceUnder(price);
    }

    @GetMapping(value = "/size/{size}")
    public List<ClothingBean> findBySize(@PathVariable String size) {
        return clothingService.findBySize(size);
    }

    @GetMapping(value = "/gender/{gender}")
    public List<ClothingBean> findByGender(@PathVariable ClothesGender gender) {
        return clothingService.findByGender(gender);
    }

    @GetMapping(value = "/type/{type}")
    public List<ClothingBean> findByType(@PathVariable ClothingType type) {
        return clothingService.findByType(type);
    }

    @GetMapping(value = "/{id}")
    public Clothing findById(@PathVariable Integer id) {
        return clothingService.findById(id);
    }

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return clothingService.countAllResources();
    }
}
