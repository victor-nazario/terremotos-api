package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.MedicalDevicesBean;
import com.terremotospr.services.MedicalDevicesService;
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
@RequestMapping("/medicaldevices")
public class MedicalDevicesController {

    @Autowired
    MedicalDevicesService medicalDevicesService;
    @PostMapping(value = "/add")
    public Boolean add(@RequestBody MedicalDevicesBean bean){
        return medicalDevicesService.addMedicalDevice(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<MedicalDevicesBean> fetchAll(){
//        return medicalDevicesService.fetchAllMedicalDevices();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/medicalDevicesResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
