package com.terremotospr.controllers.resourcesControllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.ToolBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Tool;
import com.terremotospr.services.resourceServices.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    ToolService toolService;

    @GetMapping(value = "/fetch")
    public List<ToolBean> fetchAllTool(){
        return toolService.fetchAllTool();
    }

    @PostMapping(value = "/add")
    public boolean addTool(@RequestBody ToolBean bean){
        return toolService.addTool(bean);
    }

    @GetMapping(value = "/{id}")
    public Tool findById(@PathVariable Long id) {
        return toolService.findById(id);
    }
}
