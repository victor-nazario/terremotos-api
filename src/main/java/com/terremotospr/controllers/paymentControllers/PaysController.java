package com.terremotospr.controllers.paymentControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.paymentBeans.PaysBean;
import com.terremotospr.services.paymentServices.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

//    @GetMapping(value = "/fetch")
//    public List<PaysBean> fetchAll(){
//        return paysService.fetchAllPays();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/paysResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
