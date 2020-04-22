package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.CompanyBean;
import com.terremotospr.beans.administrativeBeans.SupplierBean;
import com.terremotospr.database.entities.administrativeEntities.Company;
import com.terremotospr.database.entities.administrativeEntities.Supplier;
import com.terremotospr.database.repositories.administrativeRepositories.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 * @author Wilfredo Aponte Pomales
 */
@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Boolean addSupplier(SupplierBean bean) {
        if(bean == null) return false;

        Supplier entity = new Supplier();
        BeanUtils.copyProperties(bean, entity, "company");
        entity.setCompId(bean.getCompId());
        supplierRepository.save(entity);
        return true;
    }

    private SupplierBean copyProperties(Supplier entity){
        SupplierBean bean = new SupplierBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    private Company companyConverter(CompanyBean bean){
        Company entity = new Company();
        BeanUtils.copyProperties(bean,entity);
        return entity;
    }

    public List<SupplierBean> fetchAllSupplier(){
        List<SupplierBean> supplier;
        Iterable<Supplier> iter = supplierRepository.findAll();

        supplier = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return supplier;
    }

    public Supplier findSupplierById(Integer id){
            return supplierRepository.findById(id);
    }

    /*  private Long comp_id;
    private String cName;
    private String cLocation;*/
}
