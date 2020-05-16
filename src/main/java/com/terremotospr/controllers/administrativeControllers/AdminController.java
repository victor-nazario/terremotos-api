package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.AdminBean;
import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
import com.terremotospr.services.administrativeServices.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on March 17, 2020 - 1:02 AM
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/fetch")
    public List<AdminBean> fetchAdmin(){
         return adminService.fetchAllAdmin();
    }

    @PostMapping(value = "/add")
    public boolean addAdmin(@RequestBody AdminBean bean){
        return adminService.addAdmin(bean);
    }

    @GetMapping(value = "/{id}")
    public AdminBean findAdminById(@PathVariable Long id) {
        return adminService.findById(id);
    }
}
