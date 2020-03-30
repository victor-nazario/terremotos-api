package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.DieselBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.services.resourceServices.DieselService;
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
@RequestMapping("/diesel")
public class DieselController {
    @Autowired
    DieselService dieselService;

    @GetMapping(value = "/fetch")
    public Object fetchAvailableDiesel() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/dieselResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

    @PostMapping(value = "/add")
    public boolean addDiesel(@RequestBody DieselBean bean){
        return dieselService.addDiesel(bean);
    }
}
