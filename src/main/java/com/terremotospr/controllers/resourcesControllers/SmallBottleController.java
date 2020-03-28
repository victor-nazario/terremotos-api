package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.SmallBottleBean;
import com.terremotospr.services.SmallBottleService;
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
@RequestMapping(value = "/smallbottle")
public class SmallBottleController {

    @Autowired
    SmallBottleService smallBottleService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody SmallBottleBean bean) {
        return smallBottleService.addSmallBottle(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<SmallBottleBean> fetchAll(){
//        return smallBottleService.fetchAllSmallBottles();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/smallBottleResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
