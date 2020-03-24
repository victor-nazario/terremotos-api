package com.terremotospr.controllers;

import com.terremotospr.beans.BelongsBean;
import com.terremotospr.services.BelongsService;
import com.terremotospr.services.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/belongs")
public class BelongsController {
    @Autowired
    BelongsService belongsService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody BelongsBean bean){
        return belongsService.addBelongs(bean);
    }

    @GetMapping(value = "/fetch")
    public List<BelongsBean> fetchAll(){
        return belongsService.fetchAllBelongs();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/suppliesResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
//    }
}
