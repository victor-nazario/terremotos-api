package com.terremotospr.controllers;

import com.terremotospr.beans.MedicationBean;
import com.terremotospr.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/medications")
public class MedicationController {
    @Autowired
    MedicationService medicationService;

    @GetMapping(value = "/add")
    public Boolean add(@RequestBody MedicationBean bean){
        return medicationService.addMedication(bean);
    }
}
