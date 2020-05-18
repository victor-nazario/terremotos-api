package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.ManagesBean;
import com.terremotospr.services.administrativeServices.ManagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
@RestController
@RequestMapping("/manages")
@CrossOrigin("*")
public class ManagesController {
    @Autowired
    ManagesService managesService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ManagesBean bean){
        return managesService.addManages(bean);
    }

    @GetMapping(value = "/fetch")
    public List<ManagesBean> fetchAll(){
        return managesService.fetchAllManages();
    }

    @GetMapping(value = "/user/{id}")
    public List<ManagesBean> findByUserId(@PathVariable Integer id) { return managesService.findByUserId(id); }

    @GetMapping(value = "/admin/{id}")
    public List<ManagesBean> findByAdminId(@PathVariable Integer id) { return managesService.findByAdminId(id); }

    @GetMapping(value = "/account_status/{status}")
    public List<ManagesBean> findByAccountStatus(@PathVariable String status) { return managesService.findByAccountStatus(status); }
}
