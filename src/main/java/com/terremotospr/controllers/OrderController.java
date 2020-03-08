package com.terremotospr.controllers;

import com.terremotospr.beans.OrderBean;
import com.terremotospr.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on March 7, 2020 - 9:25 PM
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/fetchAll")
    public List<OrderBean> fetchAll(){
        return orderService.fetchAllOrder();
    }
}
