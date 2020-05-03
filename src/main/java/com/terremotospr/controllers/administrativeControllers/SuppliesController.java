package com.terremotospr.controllers.administrativeControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.administrativeBeans.SuppliesBean;
import com.terremotospr.database.entities.resourceEntities.Clothing;
import com.terremotospr.services.administrativeServices.SuppliesService;
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
@RequestMapping("/supplies")
public class SuppliesController {

    @Autowired
    SuppliesService suppliesService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody SuppliesBean bean){
        return suppliesService.addSupplies(bean);
    }

    @GetMapping(value = "/fetch")
    public List<SuppliesBean> fetchAll(){
        return suppliesService.fetchAllSupplies();
    }

    @GetMapping(value = "/supplier/{id}")
    public List<SuppliesBean> findBySupplierId(@PathVariable Integer id) { return suppliesService.findBySupplierId(id); }

    @GetMapping(value = "/resource/{id}")
    public List<SuppliesBean> findByResourceId(@PathVariable Integer id) { return suppliesService.findByResourceId(id); }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/suppliesResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}
