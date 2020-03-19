package com.terremotospr.services;

import com.terremotospr.beans.BaseResourceBean;
import com.terremotospr.beans.SupplierBean;
import com.terremotospr.beans.SuppliesBean;
import com.terremotospr.database.entities.BaseResource;
import com.terremotospr.database.entities.Supplier;
import com.terremotospr.database.entities.Supplies;
import com.terremotospr.database.repositories.SuppliesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SuppliesService {
    @Autowired
    SuppliesRepository suppliesRepository;

    public Boolean addSupplies(SuppliesBean bean) {
        if(bean == null) return false;

        Supplies entity = new Supplies();
        BeanUtils.copyProperties(bean, entity, "supplier", "resources");
        entity.setSupplier(supplierConverter(bean.getSupplier()));
        entity.setResource(resourceConverter(bean.getResource()));
        suppliesRepository.save(entity);
        return true;
    }

    private SuppliesBean copyProperties(Supplies entity){
        SuppliesBean bean = new SuppliesBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    private Supplier supplierConverter(SupplierBean bean){
        Supplier entity = new Supplier();
        BeanUtils.copyProperties(bean,entity);
        return entity;
    }

    private BaseResource resourceConverter(BaseResourceBean bean){
        BaseResource entity = new BaseResource();
        BeanUtils.copyProperties(bean,entity);
        return entity;
    }

    public List<SuppliesBean> fetchAllSupplies(){
        List<SuppliesBean> supplies;
        Iterable<Supplies> iter = suppliesRepository.findAll();

        supplies = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return supplies;
    }
}
