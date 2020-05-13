package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.ConsumerBean;
import com.terremotospr.beans.administrativeBeans.ConsumerType;
import com.terremotospr.database.entities.administrativeEntities.Consumer;
import com.terremotospr.services.administrativeServices.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/consumer")
@CrossOrigin("*")
public class ConsumerController {

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
    public Consumer findConsumerById(@PathVariable int id) {
        return consumerService.findConsumerById(id);
    }

    @GetMapping(value = "/city/{city}")
    public List<ConsumerBean> findConsumerByCity(@PathVariable String city) {
        return consumerService.findByCity(city);
    }

    @GetMapping(value = "/region/{region}")
    public List<ConsumerBean> findConsumerByRegion(@PathVariable String region) {
        return consumerService.findByRegion(region);
    }

    @GetMapping(value = "/type/{type}")
    public List<ConsumerBean> findConsumerByType(@PathVariable String type) {
        return consumerService.findByType(type);
    }

}