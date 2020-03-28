package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.CannedFoodBean;
import com.terremotospr.services.CannedFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/cannedfood")
public class CannedFoodController {

    @Autowired
    CannedFoodService cannedFoodService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody CannedFoodBean bean) {
        return cannedFoodService.addCannedFood(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<CannedFoodBean> fetchAll(){
//        return cannedFoodService.fetchAllCannedFood();
//    }
//
    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/cannedFoodResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}