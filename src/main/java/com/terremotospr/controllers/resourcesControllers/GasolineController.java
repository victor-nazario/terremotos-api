package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.GasolineBean;
import com.terremotospr.services.resourceServices.GasolineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@RestController
@RequestMapping(value = "/gasoline")
public class GasolineController {

    @Autowired
    GasolineService gasolineService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody GasolineBean bean) {
        return gasolineService.addGasoline(bean);
    }

    //        @GetMapping(value = "/fetch")
//    public List<GasolineBean> fetchAll(){
//        return gasolineService.fetchAllGasoline();
//    }
//
    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/gasolineResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}