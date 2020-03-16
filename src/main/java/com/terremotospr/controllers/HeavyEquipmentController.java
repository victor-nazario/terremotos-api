package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.HeavyEquipmentBean;
import com.terremotospr.services.HeavyEquipmentService;
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
@RequestMapping(value = "/heavyequipment")
public class HeavyEquipmentController {

    @Autowired
    HeavyEquipmentService heavyEquipmentService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody HeavyEquipmentBean bean) {
        return heavyEquipmentService.addHeavyEquipment(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<HeavyEquipmentBean> fetchAll(){
//       return heavyEquipmentService.fetchAllHeavyEquipment();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/heavyEquipmentResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}