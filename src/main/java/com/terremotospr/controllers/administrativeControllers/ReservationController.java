package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.ReservationBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.administrativeEntities.Reservation;
import com.terremotospr.services.administrativeServices.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public List<ReservationBean> fetchReservation(){
        return reservationService.fetchAllReservation();
    }

    @PostMapping(value = "/add")
    public boolean addReservation(@RequestBody ReservationBean bean){
        return reservationService.addReservation(bean);
    }

    @GetMapping(value = "/{id}")
    public Reservation findId(@PathVariable Long id) {
        return reservationService.findById(id);
    }
}
