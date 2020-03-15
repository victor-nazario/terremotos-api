package com.terremotospr.services;

import com.terremotospr.beans.GasolineBean;
import com.terremotospr.database.entities.Gasoline;
import com.terremotospr.database.repositories.GasolineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}