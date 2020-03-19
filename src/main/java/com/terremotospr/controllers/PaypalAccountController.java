package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.PaypalAccountBean;
import com.terremotospr.services.PaypalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/paypalaccount")
public class PaypalAccountController {
    @Autowired
    PaypalAccountService paypalAccountService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody PaypalAccountBean bean){
        return paypalAccountService.addPaypalAccount(bean);
    }

    @GetMapping(value = "/fetch")
    public List<PaypalAccountBean> fetchAll(){
        return paypalAccountService.fetchAllPaypalAccount();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/paypalAccountResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}
