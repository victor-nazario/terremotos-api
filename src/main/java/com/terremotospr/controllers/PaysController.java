package com.terremotospr.controllers;

import com.terremotospr.beans.PaysBean;
import com.terremotospr.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@RestController
@RequestMapping("/pays")
public class PaysController {
    @Autowired
    PaysService paysService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody PaysBean bean){
        return paysService.addPays(bean);
    }

    @GetMapping(value = "/fetch")
    public List<PaysBean> fetchAll(){
        return paysService.fetchAllPays();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/paysResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
}
