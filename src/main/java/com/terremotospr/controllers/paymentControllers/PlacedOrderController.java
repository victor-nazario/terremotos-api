package com.terremotospr.controllers.paymentControllers;

import com.terremotospr.beans.paymentBeans.PlacedOrderBean;
import com.terremotospr.database.entities.paymentEntities.PlacedOrder;
import com.terremotospr.services.paymentServices.PlacedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<PlacedOrderBean> fetchOrder() { return placedOrderService.fetchAllOrder(); }

    @PostMapping(value = "/add")
    public boolean addOrder(@RequestBody PlacedOrderBean bean){
        return placedOrderService.addOrder(bean);
    }

    @GetMapping(value = "/{id}")
    public PlacedOrder findOrderById(@PathVariable Long id) {
        return placedOrderService.findById(id);
    }
}
