package com.terremotospr.controllers;

import com.terremotospr.beans.ConsumerBean;
import com.terremotospr.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/company")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody ConsumerBean bean) {
        return consumerService.addConsumer(bean);
    }

    @GetMapping(value = "/fetch")
    public List<ConsumerBean> fetchAll(){
        return consumerService.fetchAllConsumer();
    }
//
//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/consumerResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}