package com.terremotospr.controllers.paymentControllers;

import com.terremotospr.beans.paymentBeans.PaysBean;
import com.terremotospr.services.paymentServices.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@RestController
@RequestMapping("/pays")
public class PaysController {
    @Autowired
    PaysService paysService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody PaysBean bean){
        return paysService.addPays(bean);
    }

    @GetMapping(value = "/fetch")
    public List<PaysBean> fetchAll(){
        return paysService.fetchAllPays();
    }

    @GetMapping(value = "/payment/{id}")
    public List<PaysBean> findByPaymentId(@PathVariable Long id) { return paysService.findByPaymentId(id); }

    @GetMapping(value = "/order/{id}")
    public List<PaysBean> findByPlacedOrderId(@PathVariable Long id) { return paysService.findByPlacedOrderId(id); }
}
