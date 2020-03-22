package com.terremotospr.controllers;

import com.terremotospr.beans.PlacedOrderBean;
import com.terremotospr.services.PlacedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public List<PlacedOrderBean> fetchOrder() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/AdminResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
        return placedOrderService.fetchAllOrder();
    }

    @PostMapping(value = "/add")
    public boolean addOrder(@RequestBody PlacedOrderBean bean){
        return placedOrderService.addOrder(bean);
    }
}
