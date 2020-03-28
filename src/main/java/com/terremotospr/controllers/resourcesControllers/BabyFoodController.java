package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.BabyFoodBean;
import com.terremotospr.services.BabyFoodService;
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

}
