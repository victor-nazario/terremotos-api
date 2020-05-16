package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.CompanyBean;
import com.terremotospr.database.entities.administrativeEntities.Company;
import com.terremotospr.services.administrativeServices.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@RestController
@RequestMapping(value = "/company")
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody CompanyBean bean) {
        return companyService.addCompany(bean);
    }

    @GetMapping(value = "/fetch")
    public List<CompanyBean> fetchAll(){ return companyService.fetchAllCompany(); }

    @GetMapping(value = "/{id}")
    public Company findCompanyById(@PathVariable int id) {
        return companyService.findCompanyById(id);
    }

    @GetMapping(value = "/name/{name}")
    public List<CompanyBean> findCompanyByName(@PathVariable String name) {
        return companyService.findByCompanyName(name);
    }

    @GetMapping(value = "/location/{location}")
    public List<CompanyBean> findCompanyByLocation(@PathVariable String location) {
        return companyService.findByCompanyLocation(location);
    }

}