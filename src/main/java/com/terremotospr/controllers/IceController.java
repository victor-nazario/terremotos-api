package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.IceBean;
import com.terremotospr.services.IceService;
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
@RequestMapping(value = "/ice")
public class IceController {

    @Autowired
    IceService iceService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody IceBean bean) {
        return iceService.addIce(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<IceBean> fetchAll(){
//        return iceService.fetchAllIce();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/iceResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}