package com.terremotospr.controllers.paymentControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.paymentBeans.PaymentBean;
import com.terremotospr.services.paymentServices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

//    @GetMapping(value = "/fetch")
//    public List<PaymentBean> fetchAll(){
//        return paymentService.fetchAllPayment();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        Resource resource = new ClassPathResource("responses/paymentResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }

}
