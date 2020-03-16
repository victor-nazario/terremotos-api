package com.terremotospr.services;

import com.terremotospr.beans.ConsumerBean;
import com.terremotospr.beans.SupplierBean;
import com.terremotospr.database.entities.Consumer;
import com.terremotospr.database.entities.Supplier;
import com.terremotospr.database.repositories.ConsumerRepository;
import com.terremotospr.database.repositories.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Boolean addSupplier(SupplierBean bean) {
        if(bean == null) return false;

        Supplier entity = new Supplier();
        BeanUtils.copyProperties(bean, entity);
        supplierRepository.save(entity);
        return true;
    }

    private SupplierBean copyProperties(Supplier entity){
        SupplierBean bean = new SupplierBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<SupplierBean> fetchAllSupplier(){
        List<SupplierBean> supplier;
        Iterable<Supplier> iter = supplierRepository.findAll();

        supplier = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return supplier;
    }
}
