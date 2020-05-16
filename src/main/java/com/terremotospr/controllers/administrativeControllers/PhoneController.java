package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.AdminBean;
import com.terremotospr.beans.administrativeBeans.PhoneBean;
import com.terremotospr.database.entities.administrativeEntities.Phone;
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
@CrossOrigin("*")
public class PhoneController {


    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/fetch")
    public List<PhoneBean> fetchAllPhone() throws IOException {
      return phoneService.fetchAllPhone();
    }

    @PostMapping(value = "/add")
    public boolean addPhone(@RequestBody()PhoneBean bean) {
        return phoneService.addPhone(bean);
    }

    @GetMapping(value = "/{id}")
    public PhoneBean findPhoneById(@PathVariable Long id) {
        return phoneService.findById(id);
    }
}
