package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.BelongsBean;
import com.terremotospr.beans.administrativeBeans.SuppliesBean;
import com.terremotospr.services.administrativeServices.BelongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/belongs")
public class BelongsController {
    @Autowired
    BelongsService belongsService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody BelongsBean bean){
        return belongsService.addBelongs(bean);
    }

    @GetMapping(value = "/fetch")
    public List<BelongsBean> fetchAll(){
        return belongsService.fetchAllBelongs();
    }

    @GetMapping(value = "/order/{id}")
    public List<BelongsBean> findByOrderId(@PathVariable Integer id) { return belongsService.findByOrderId(id); }

    @GetMapping(value = "/resource/{id}")
    public List<BelongsBean> findByResourceId(@PathVariable Integer id) { return belongsService.findByResourceId(id); }

}
