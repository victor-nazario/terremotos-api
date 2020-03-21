package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.SuppliesBean;
import com.terremotospr.services.SuppliesService;
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

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/suppliesResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}
