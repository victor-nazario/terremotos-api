package com.terremotospr.controllers.paymentControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.paymentBeans.PaymentMethodBean;
import com.terremotospr.services.paymentServices.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/30/2020
 */
@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping(value = "/fetch")
    public Object fetchAllPaymentMethod() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/paymentMethodResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

    @PostMapping(value = "/add")
    public boolean addPaymentMethod(@RequestBody()PaymentMethodBean bean) {
        return paymentMethodService.addPaymentMethod(bean);
    }
}
