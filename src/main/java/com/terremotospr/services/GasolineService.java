package com.terremotospr.services;

import com.terremotospr.beans.GasolineBean;
import com.terremotospr.database.entities.resourceEntities.Gasoline;
import com.terremotospr.database.repositories.resourceRepositories.GasolineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@Service
public class GasolineService {

    @Autowired
    GasolineRepository gasolineRepository;

    public Boolean addGasoline(GasolineBean bean) {
        if(bean == null) return false;

        Gasoline entity = new Gasoline();
        BeanUtils.copyProperties(bean, entity);
        gasolineRepository.save(entity);
        return true;
    }

    private GasolineBean copyProperties(Gasoline entity){
        GasolineBean bean = new GasolineBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<GasolineBean> fetchAllGasoline(){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findAll();

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }
}