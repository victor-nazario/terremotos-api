package com.terremotospr.controllers.resourcesControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terremotospr.beans.resourceBeans.PowerGenBean;
import com.terremotospr.beans.resourceBeans.generatorType;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
import com.terremotospr.services.resourceServices.PowerGenService;
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
@RequestMapping("/powergenerator")
public class PowerGenController {

    @Autowired
    PowerGenService powerGenService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody PowerGenBean bean) { return powerGenService.addPowerGen(bean); }

    @GetMapping(value = "/fetch")
    public List<PowerGenBean> fetchAll(){
        return powerGenService.fetchAllPowerGen();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/powerGeneratorResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }

    @GetMapping(value = "/{id}")
    public PowerGen findPowerGenById(@PathVariable int id) {
        return powerGenService.findById(id);
    }

    @GetMapping(value = "/brand/{brand}")
    public List<PowerGenBean> findByBrand(@PathVariable String brand) {
        return powerGenService.findByBrand(brand);
    }

    @GetMapping(value = "/name/{name}")
    public List<PowerGenBean> findByName(@PathVariable String name) {
        return powerGenService.findByName(name);
    }

    @GetMapping(value = "/price_under/{price}")
    public List<PowerGenBean> findByPriceUnder(@PathVariable Double price) {
        return powerGenService.findByPriceUnder(price);
    }

    @GetMapping(value = "/power/{power}")
    public List<PowerGenBean> findByPower(@PathVariable String power) {
        return powerGenService.findByPower(power);
    }

    @GetMapping(value = "/generatortype/{type}")
    public List<PowerGenBean> findByGeneratorType(@PathVariable generatorType type) {
        return powerGenService.findByGeneratorType(type);
    }
}
