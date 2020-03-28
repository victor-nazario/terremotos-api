package com.terremotospr.controllers.paymentControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.paymentBeans.PlacedOrderBean;
import com.terremotospr.services.paymentServices.PlacedOrderService;
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
@RequestMapping("/order")
public class PlacedOrderController {

    @Autowired
    PlacedOrderService placedOrderService;

    @GetMapping(value = "/fetch")
    public Object fetchOrder() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/placedOrderJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
        //return placedOrderService.fetchAllOrder();
    }

    @PostMapping(value = "/add")
    public boolean addOrder(@RequestBody PlacedOrderBean bean){
        return placedOrderService.addOrder(bean);
    }
}
