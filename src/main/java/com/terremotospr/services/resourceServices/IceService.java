package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.IceBean;
import com.terremotospr.database.entities.resourceEntities.Ice;
import com.terremotospr.database.repositories.resourceRepositories.IceRepository;
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
public class IceService {

    @Autowired
    IceRepository iceRepository;

    public Boolean addIce(IceBean bean) {
        if(bean == null) return false;

        Ice entity = new Ice();
        BeanUtils.copyProperties(bean, entity);
        iceRepository.save(entity);
        return true;
    }

    private IceBean copyProperties(Ice entity){
        IceBean bean = new IceBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<IceBean> fetchAllIce(){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findAll();

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }
}