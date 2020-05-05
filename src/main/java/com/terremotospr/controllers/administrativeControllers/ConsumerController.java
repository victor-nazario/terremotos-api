package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.ConsumerBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.administrativeEntities.Consumer;
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

    @GetMapping(value = "/fetch")
    public List<ConsumerBean> fetchAll(){
        return consumerService.fetchAllConsumer();
    }

    @GetMapping(value = "/{id}")
    public Consumer findById(@PathVariable Long id) {
        return consumerService.findById(id);
    }
}