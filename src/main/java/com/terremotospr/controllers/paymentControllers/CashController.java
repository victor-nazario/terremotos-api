package com.terremotospr.controllers.paymentControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.paymentBeans.CashBean;
import com.terremotospr.services.paymentServices.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cash")
public class CashController {
    @Autowired
    CashService cashService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody CashBean bean){
        return cashService.addCash(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<CashBean> fetchAll(){
//        return cashService.fetchAllCash();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/cashResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
