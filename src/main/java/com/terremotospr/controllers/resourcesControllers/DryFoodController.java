package com.terremotospr.controllers.resourcesControllers;

import com.terremotospr.beans.resourceBeans.DryFoodBean;
import com.terremotospr.services.resourceServices.DryFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * @author Wilfredo Aponte Pomales
 */
@RestController
@RequestMapping("/dryfood")
public class DryFoodController {

    @Autowired
    DryFoodService dryFoodService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody DryFoodBean bean){
        return dryFoodService.addDryFood(bean);
    }

    @GetMapping(value = "/fetch")
    public List<DryFoodBean> fetchAll(){
        return dryFoodService.fetchAllDryFood();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/dryFoodResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }

}
