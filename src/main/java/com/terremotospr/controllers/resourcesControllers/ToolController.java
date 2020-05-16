package com.terremotospr.controllers.resourcesControllers;


import com.terremotospr.beans.resourceBeans.ToolBean;
import com.terremotospr.database.entities.resourceEntities.Tool;
import com.terremotospr.services.resourceServices.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/tool")
@CrossOrigin("*")
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

    @GetMapping(value = "/name/{name}")
    public List<ToolBean> findByName(@PathVariable String name){ return toolService.findByName(name); }

    @GetMapping(value = "/available")
    public List<ToolBean> findAvailable(){ return toolService.findAvailable();}

    @GetMapping(value = "/count/all")
    public Long countAll() {
        return toolService.countAllResources();
    }
}
