package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.PowerGenBean;
import com.terremotospr.services.resourceServices.PowerGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/powergenerator")
public class PowerGenController {

    @Autowired
    PowerGenService powerGenService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody PowerGenBean bean) { return powerGenService.addPowerGen(bean); }

//    @GetMapping(value = "/fetch")
//    public List<PowerGenBean> fetchAll(){
//        return powerGenService.fetchAllPowerGen();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/powerGeneratorResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

}
