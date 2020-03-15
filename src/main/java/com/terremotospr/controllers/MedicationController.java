package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.MedicationBean;
import com.terremotospr.beans.PersonBean;
import com.terremotospr.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/medications")
public class MedicationController {
    @Autowired
    MedicationService medicationService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody MedicationBean bean){
        return medicationService.addMedication(bean);
    }

//    @GetMapping(value = "/fetch")
//    public List<MedicationBean> fetchAll(){
//        return medicationService.fetchAllMedication();
//    }

    @GetMapping(value = "/fetch")
    public Object fetchAll() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/medicationResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
