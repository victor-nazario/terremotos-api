package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.ReservesBean;
import com.terremotospr.services.administrativeServices.ReservesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@RestController
@RequestMapping("/reserves")
@CrossOrigin("*")
public class ReservesController {
    @Autowired
    ReservesService reservesService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ReservesBean bean){
        return reservesService.addReserves(bean);
    }

    @GetMapping(value = "/fetch")
    public List<ReservesBean> fetchAll(){
        return reservesService.fetchAllReserves();
    }

    @GetMapping(value = "/reservation/{id}")
    public List<ReservesBean> findByReservationId(@PathVariable Integer id) { return reservesService.findByReservationId(id); }

    @GetMapping(value = "/resource/{id}")
    public List<ReservesBean> findByResourceId(@PathVariable Integer id) { return reservesService.findByResourceId(id); }

    @GetMapping(value = "/quantity_over/{quantity}")
    public List<ReservesBean> findByReservedQuantityOver(@PathVariable Integer quantity) { return reservesService.findByReservedQuantityOver(quantity); }

    @GetMapping(value = "/quantity_under/{quantity}")
    public List<ReservesBean> findByReservedQuantityUnder(@PathVariable Integer quantity) { return reservesService.findByReservedQuantityUnder(quantity); }


}
