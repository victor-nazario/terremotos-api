package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.ReservesBean;
import com.terremotospr.services.administrativeServices.ReservesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@RestController
@RequestMapping("/reserves")
public class ReservesController {
    @Autowired
    ReservesService reservesService;

    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ReservesBean bean){
        return reservesService.addReserves(bean);
    }

    @GetMapping(value = "/fetch")
    public List<ReservesBean> fetchAll(){
        return reservesService.fetchAllReserves();
    }

//    @GetMapping(value = "/fetch")
//    public Object fetchAll() throws IOException {
//        //To obtain the path, in IDEA right click and when the dialog shows up, select copy path -> path from source root
//        Resource resource = new ClassPathResource("responses/reservesResponseJSON.json");
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(resource.getInputStream(), Object.class);
}
