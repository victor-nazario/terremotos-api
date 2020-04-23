package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.ConsumerBean;
import com.terremotospr.services.administrativeServices.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody ConsumerBean bean) {
        return consumerService.addConsumer(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<ConsumerBean> fetchAll(){
//        return consumerService.fetchAllConsumer();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/consumerResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}