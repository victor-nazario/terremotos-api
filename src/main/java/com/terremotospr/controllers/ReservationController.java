package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.ReservationBean;
import com.terremotospr.beans.WaterBean;
import com.terremotospr.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "/fetch")
    public Object fetchReservation() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
        Resource resource = new ClassPathResource("responses/reservationResponseJSON.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource.getInputStream(), Object.class);
   //     return reservationService.fetchAllReservation();
    }

    @PostMapping(value = "/add")
    public boolean addReservation(@RequestBody ReservationBean bean){
        return reservationService.addReservation(bean);
    }
}
