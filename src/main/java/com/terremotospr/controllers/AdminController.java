package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.AdminBean;
import com.terremotospr.beans.WaterBean;
import com.terremotospr.database.repositories.AdminRepository;
import com.terremotospr.services.AdminService;
import com.terremotospr.services.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created on March 17, 2020 - 1:02 AM
 *
 * @author Victor Nazario
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/fetch")
    public List<AdminBean> fetchAdmin() throws IOException {
        //To obtain the path, in IDEA rightclick and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/AdminResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
        return adminService.fetchAllAdmin();
    }

    @PostMapping(value = "/add")
    public boolean addAdmin(@RequestBody AdminBean bean){
        return adminService.addAdmin(bean);
    }
}
