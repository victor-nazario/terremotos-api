package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.ClothingBean;
import com.terremotospr.database.repositories.ClothingRepository;
import com.terremotospr.services.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    ClothingService clothingService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ClothingBean bean){
        return clothingService.addClothing(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<ClothingBean> fetchAll(){
//        return clothingService.fetchAllClothing();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/clothingResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
