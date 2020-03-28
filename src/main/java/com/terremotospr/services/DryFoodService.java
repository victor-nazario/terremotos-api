package com.terremotospr.services;

import com.terremotospr.beans.DryFoodBean;
import com.terremotospr.database.entities.resourceEntities.DryFood;
import com.terremotospr.database.repositories.resourceRepositories.DryFoodRepository;
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
public class DryFoodService {

    @Autowired
    DryFoodRepository dryFoodRepository;

    public Boolean addDryFood(DryFoodBean bean){
        if(bean == null) return false;

        DryFood entity = new DryFood();
        BeanUtils.copyProperties(bean, entity);
        dryFoodRepository.save(entity);
        return true;

    }

    public List<DryFoodBean> fetchAllDryFood(){
        List<DryFoodBean> dryFood;

        Iterable<DryFood> iter = dryFoodRepository.findAll();

        dryFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return dryFood;
    }

    private DryFoodBean copyProperties(DryFood entity){
        DryFoodBean bean = new DryFoodBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

}
