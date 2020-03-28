package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.SuppliesBean;
import com.terremotospr.database.entities.administrativeEntities.Supplies;
import com.terremotospr.database.repositories.administrativeRepositories.SuppliesRepository;
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
        entity.setSupplierId(bean.getSupplierId());
        entity.setResourceId(bean.getResourceId());
        suppliesRepository.save(entity);
        return true;
    }

    private SuppliesBean copyProperties(Supplies entity){
        SuppliesBean bean = new SuppliesBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
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
