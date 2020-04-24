package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.SupplierBean;
import com.terremotospr.database.entities.administrativeEntities.Supplier;
import com.terremotospr.services.administrativeServices.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public Supplier findSupplierById(@PathVariable int id) {
        return supplierService.findSupplierById(id);
    }

    @GetMapping(value = "/position/{position}")
    public List<SupplierBean> findSupplierByPosition(@PathVariable String position) {
        return supplierService.findByPosition(position);
    }

    @GetMapping(value = "/city/{city}")
    public List<SupplierBean> findSupplierByCity(@PathVariable String city) {
        return supplierService.findByCity(city);
    }

    @GetMapping(value = "/region/{region}")
    public List<SupplierBean> findSupplierByRegion(@PathVariable String region) {
        return supplierService.findByRegion(region);
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/supplierResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}
