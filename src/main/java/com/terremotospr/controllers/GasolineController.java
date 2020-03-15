package com.terremotospr.controllers;

import com.terremotospr.beans.GasolineBean;
import com.terremotospr.services.GasolineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@RestController
@RequestMapping(value = "/gasoline")
public class GasolineController {

    @Autowired
    GasolineService gasolineService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody GasolineBean bean){
        return gasolineService.addGasoline(bean);
    }
}