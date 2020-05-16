package com.terremotospr.controllers.paymentControllers;

import com.terremotospr.beans.paymentBeans.PaymentBean;
import com.terremotospr.database.entities.paymentEntities.Payment;
import com.terremotospr.services.paymentServices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/19/2020
 */

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody PaymentBean bean) {
        return paymentService.addPayment(bean);
    }

    @GetMapping(value = "/fetch")
    public List<PaymentBean> fetchAll(){ return paymentService.fetchAllPayment(); }

    @GetMapping(value = "/{id}")
    public Payment findById(@PathVariable Integer id) {
        return paymentService.findPaymentById(id);
    }

    @GetMapping(value = "/consumer/{id}")
    public Payment findByConsumerId(@PathVariable Integer id) {
        return paymentService.findByConsumerId(id);
    }

    @GetMapping(value = "/total_under/{total}")
    public List<PaymentBean> findByPurchaseTotalUnder(@PathVariable Double total){ return paymentService.findByPurchaseTotalUnder(total); }

    @GetMapping(value = "/total_over/{total}")
    public List<PaymentBean> findByPurchaseTotalOver(@PathVariable Double total){ return paymentService.findByPurchaseTotalOver(total);}
}
