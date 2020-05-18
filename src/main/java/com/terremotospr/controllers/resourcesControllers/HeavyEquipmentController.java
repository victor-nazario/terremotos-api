package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.HeavyEquipmentBean;
import com.terremotospr.beans.resourceBeans.TypeofHeavyEquipment;
import com.terremotospr.database.entities.resourceEntities.HeavyEquipment;
import com.terremotospr.services.resourceServices.HeavyEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/heavyequipment")
@CrossOrigin("*")
public class HeavyEquipmentController {

    @Autowired
    HeavyEquipmentService heavyEquipmentService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody HeavyEquipmentBean bean) {
        return heavyEquipmentService.addHeavyEquipment(bean);
    }

    @GetMapping(value = "/fetch") public List<HeavyEquipmentBean> fetchAll(){ return heavyEquipmentService.fetchAllHeavyEquipment(); }

    @GetMapping(value = "/{id}")
    public HeavyEquipment findHeavyEquipmentById(@PathVariable int id){ return heavyEquipmentService.findById(id); }

    @GetMapping(value = "/price_under/{price}")
    public List<HeavyEquipmentBean> findByPriceUnder(@PathVariable Double price){ return heavyEquipmentService.findByPriceUnder(price); }

    @GetMapping(value = "/price_over/{price}")
    public List<HeavyEquipmentBean> findByPriceOver(@PathVariable Double price){ return heavyEquipmentService.findByPriceOver(price); }

    @GetMapping(value = "/brand/{brand}")
    public List<HeavyEquipmentBean> findByBrand(@PathVariable String brand){ return heavyEquipmentService.findByBrand(brand); }

    @GetMapping(value = "/name/{name}")
    public List<HeavyEquipmentBean> findByName(@PathVariable String name){ return heavyEquipmentService.findByName(name); }

    @GetMapping(value = "/available")
    public List<HeavyEquipmentBean> findAvailable(){ return heavyEquipmentService.findAvailable(); }

    @GetMapping(value = "/size/{size}")
    public List<HeavyEquipmentBean> findBySize(@PathVariable Double size){ return heavyEquipmentService.findBySize(size); }

    @GetMapping(value = "/type/{type}")
    public List<HeavyEquipmentBean> findByType(@PathVariable String type){ return heavyEquipmentService.findByType(type); }

    @GetMapping(value = "/count/all")
    public Long countAll() { return heavyEquipmentService.countAllResources();}

}