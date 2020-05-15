package com.terremotospr.controllers.paymentControllers;

import com.terremotospr.beans.paymentBeans.PaymentMethodBean;
import com.terremotospr.database.entities.paymentEntities.PaymentMethod;
import com.terremotospr.services.paymentServices.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/30/2020
 */
@RestController
@RequestMapping("/paymentmethod")
@CrossOrigin("*")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @PostMapping(value = "/add")
    public boolean addPaymentMethod(@RequestBody()PaymentMethodBean bean) {
        return paymentMethodService.addPaymentMethod(bean);
    }

    @GetMapping(value = "/fetch")
    public List<PaymentMethodBean> fetchAll(){ return paymentMethodService.fetchAllPaymentMethod(); }

}
