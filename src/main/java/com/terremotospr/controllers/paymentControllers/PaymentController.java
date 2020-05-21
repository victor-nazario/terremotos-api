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
    public Payment findById(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }

    @GetMapping(value = "/consumer/{id}")
    public Payment findByConsumerId(@PathVariable Long id) {
        return paymentService.findByConsumerId(id);
    }

    @GetMapping(value = "/paid_under/{paid}")
    public List<PaymentBean> findByAmountPaidUnder(@PathVariable Double paid){ return paymentService.findByAmountPaidUnder(paid); }

    @GetMapping(value = "/paid_over/{paid}")
    public List<PaymentBean> findByAmountPaidOver(@PathVariable Double paid){ return paymentService.findByAmountPaidOver(paid);}
}
