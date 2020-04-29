package com.terremotospr.controllers.paymentControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.paymentBeans.CardBean;
import com.terremotospr.beans.paymentBeans.CashBean;
import com.terremotospr.services.paymentServices.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody CardBean bean){
        return cardService.addCard(bean);
    }

    @GetMapping(value = "/fetch")
    public List<CardBean> fetchAll(){
        return cardService.fetchAllCard();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/cardResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }

    @GetMapping(value = "/{id}")
    public CardBean findById(@PathVariable int id) {return cardService.findById(id);}
}
