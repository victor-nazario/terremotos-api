package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.PowerGenBean;
import com.terremotospr.beans.resourceBeans.PowerGeneratorType;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
import com.terremotospr.services.resourceServices.PowerGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/powergenerator")
@CrossOrigin("*")
public class PowerGenController {

    @Autowired
    PowerGenService powerGenService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody PowerGenBean bean) { return powerGenService.addPowerGen(bean); }

    @GetMapping(value = "/fetch")
    public List<PowerGenBean> fetchAll(){
        return powerGenService.fetchAllPowerGen();
    }

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
    public List<PowerGenBean> findByGeneratorType(@PathVariable PowerGeneratorType type) {
        return powerGenService.findByGeneratorType(type);
    }
//insert into base_resource (available, brand, category, description, expiration_date, latitude, longitude, name, price) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
//Hibernate: insert into power_gen (fuel_type, power, type, id) values (?, ?, ?, ?)
}
