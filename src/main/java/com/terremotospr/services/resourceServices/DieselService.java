package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.DieselBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Diesel;
import com.terremotospr.database.entities.resourceEntities.Water;
import com.terremotospr.database.repositories.resourceRepositories.DieselRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Service
public class DieselService {

    @Autowired
    DieselRepository dieselRepository;

    public List<DieselBean> fetchAllDiesel(){
        List<DieselBean> diesels;

        Iterable<Diesel> iter = dieselRepository.findAll();

        diesels = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return diesels;
    }

    private DieselBean copyProperties(Diesel entity){
        DieselBean bean = new DieselBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addDiesel(DieselBean bean) {
        if(bean == null) return false;

        Diesel entity = new Diesel();
        BeanUtils.copyProperties(bean, entity);
        dieselRepository.save(entity);
        return true;
    }
}
