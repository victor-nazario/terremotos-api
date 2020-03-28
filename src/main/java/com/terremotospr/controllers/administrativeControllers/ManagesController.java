package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.ManagesBean;
import com.terremotospr.services.ManagesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
@RestController
@RequestMapping("/manages")
public class ManagesController {

    ManagesService managesService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ManagesBean bean){
        return managesService.addManages(bean);
    }

    @GetMapping(value = "/fetch")
    public List<ManagesBean> fetchAll(){
        return managesService.fetchAllManages();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/managesResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);

}
