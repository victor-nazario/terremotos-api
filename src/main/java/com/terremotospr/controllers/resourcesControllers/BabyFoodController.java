package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.BabyFoodBean;
import com.terremotospr.database.entities.resourceEntities.BabyFood;
import com.terremotospr.services.resourceServices.BabyFoodService;
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
@RequestMapping("/babyfood")
@CrossOrigin("*")
public class BabyFoodController {

    @Autowired
    BabyFoodService babyFoodService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody BabyFoodBean bean){
        return babyFoodService.addBabyFood(bean);
    }

    @GetMapping(value = "/fetch")
    public List<BabyFoodBean> fetchAll(){
        return babyFoodService.fetchAllBabyFood();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/babyFoodResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }

    @GetMapping(value = "/{id}")
    public BabyFood findBabyFoodById(@PathVariable int id) {
        return babyFoodService.findById(id);
    }

    @GetMapping(value = "/brand/{brand}")
    public List<BabyFoodBean> findByBrand(@PathVariable String brand) {
        return babyFoodService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<BabyFoodBean> findByName(@PathVariable String name) {
        return babyFoodService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<BabyFoodBean> findByPriceUnder(@PathVariable Double price) {
        return babyFoodService.findByPriceUnder(price);
    }

    @GetMapping(value = "/size/{size}")
    public List<BabyFoodBean> findBySize(@PathVariable String size) {
        return babyFoodService.findBySize(size);
    }

    @GetMapping(value = "/available")
    public List<BabyFoodBean> findAvailable(){
        return babyFoodService.findAvailable();
    }
}
