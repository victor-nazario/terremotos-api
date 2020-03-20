package com.terremotospr.controllers;

import com.terremotospr.beans.PaymentBean;
import com.terremotospr.services.PaymentService;
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
    public List<PaymentBean> fetchAll(){
        return paymentService.fetchAllPayment();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/paymentResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }

}
