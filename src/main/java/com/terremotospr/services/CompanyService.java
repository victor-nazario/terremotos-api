package com.terremotospr.services;

import com.terremotospr.beans.CompanyBean;
import com.terremotospr.database.entities.administrativeEntities.Company;
import com.terremotospr.database.repositories.administrativeRepositories.CompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Boolean addCompany(CompanyBean bean) {
        if(bean == null) return false;

        Company entity = new Company();
        BeanUtils.copyProperties(bean, entity);
        companyRepository.save(entity);
        return true;
    }

    private CompanyBean copyProperties(Company entity){
        CompanyBean bean = new CompanyBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<CompanyBean> fetchAllCompany(){
        List<CompanyBean> companies;
        Iterable<Company> iter = companyRepository.findAll();

        companies = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return companies;
    }
}
