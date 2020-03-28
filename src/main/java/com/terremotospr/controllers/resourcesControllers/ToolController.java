package com.terremotospr.controllers.resourcesControllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.ToolBean;
import com.terremotospr.services.ToolService;
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
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    ToolService toolService;

    @GetMapping(value = "/fetch")
    public Object fetchAllTool() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/toolResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
        //return toolService.fetchAllTool();
    }

    @PostMapping(value = "/add")
    public boolean addTool(@RequestBody ToolBean bean){
        return toolService.addTool(bean);
    }
}
