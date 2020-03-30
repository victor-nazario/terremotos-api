package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.GallonBottleBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.services.resourceServices.GallonBottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/gallon")
public class GallonBottleController {
    @Autowired
    GallonBottleService gallonBottleService;

    @GetMapping(value = "/fetch")
    public Object fetchAvailableGallon() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/gallonBottleResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

    @PostMapping(value = "/add")
    public boolean addGallon(@RequestBody GallonBottleBean bean){
        return gallonBottleService.addGallon(bean);
    }
}
