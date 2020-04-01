package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.PhoneBean;
import com.terremotospr.services.administrativeServices.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created on March 17, 2020 - 12:40PM
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/phone")
public class PhoneController {


    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/fetch")
    public Object fetchAllPhone() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/phoneResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
//        return phoneService.fetchAllPhone();
    }

    @PostMapping(value = "/add")
    public boolean addPhone(@RequestBody()PhoneBean bean) {
        return phoneService.addPhone(bean);
    }
}
