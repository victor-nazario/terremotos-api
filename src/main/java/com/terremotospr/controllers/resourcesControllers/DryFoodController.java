package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.DryFoodBean;
import com.terremotospr.database.entities.resourceEntities.DryFood;
import com.terremotospr.services.resourceServices.DryFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.List;
/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/dryfood")
public class DryFoodController {

    @Autowired
    DryFoodService dryFoodService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody DryFoodBean bean){
        return dryFoodService.addDryFood(bean);
    }

    @GetMapping(value = "/fetch")
    public List<DryFoodBean> fetchAll(){
        return dryFoodService.fetchAllDryFood();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/dryFoodResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }

    @GetMapping(value = "/{id}")
    public DryFood findDryFoodById(@PathVariable int id) {
        return dryFoodService.findById(id);
    }

    @GetMapping(value = "/brand/{brand}")
    public List<DryFoodBean> findByBrand(@PathVariable String brand) {
        return dryFoodService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<DryFoodBean> findByName(@PathVariable String name) {
        return dryFoodService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<DryFoodBean> findByPriceUnder(@PathVariable Double price) {
        return dryFoodService.findByPriceUnder(price);
    }

    @GetMapping(value = "/size/{size}")
    public List<DryFoodBean> findBySize(@PathVariable String size) {
        return dryFoodService.findBySize(size);
    }

    @GetMapping(value = "/available")
    public List<DryFoodBean> findAvailable(){
        return dryFoodService.findAvailable();
    }

}
