package com.terremotospr.controllers;

import com.terremotospr.beans.WaterBean;
import com.terremotospr.services.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on March 12, 2020 - 9:30 PM
 *
 * @author Victor Nazario
 */

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    WaterService waterService;

    @GetMapping(value = "/available")
    public List<WaterBean> fetchAvailableWater(){
        return waterService.fetchAllWater();
    }
}
