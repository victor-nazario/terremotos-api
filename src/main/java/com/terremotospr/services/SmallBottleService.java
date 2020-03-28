package com.terremotospr.services;

import com.terremotospr.beans.SmallBottleBean;
import com.terremotospr.database.entities.resourceEntities.SmallBottle;
import com.terremotospr.database.repositories.resourceRepositories.SmallBottleRepository;
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
public class SmallBottleService {

    @Autowired
    SmallBottleRepository smallBottleRepository;

    public Boolean addSmallBottle(SmallBottleBean bean) {
        if(bean == null) return false;

        SmallBottle entity = new SmallBottle();
        BeanUtils.copyProperties(bean, entity);
        smallBottleRepository.save(entity);
        return true;
    }

    private SmallBottleBean copyProperties(SmallBottle entity){
        SmallBottleBean bean = new SmallBottleBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<SmallBottleBean> fetchAllSmallBottles(){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findAll();

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }
}
