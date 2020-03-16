package com.terremotospr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.ClothingBean;
import com.terremotospr.beans.SupplierBean;
import com.terremotospr.services.ClothingService;
import com.terremotospr.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody SupplierBean bean){
        return supplierService.addSupplier(bean);
    }

    @GetMapping(value = "/fetch")
    public List<SupplierBean> fetchAll(){
        return supplierService.fetchAllSupplier();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/supplierResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}
