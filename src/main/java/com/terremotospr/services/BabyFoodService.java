package com.terremotospr.services;

import com.terremotospr.beans.BabyFoodBean;
import com.terremotospr.database.entities.BabyFood;
import com.terremotospr.database.repositories.BabyFoodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BabyFoodService {
    @Autowired
    BabyFoodRepository babyFoodRepository;

    public Boolean addBabyFood(BabyFoodBean bean){
        if(bean == null) return false;

        BabyFood entity = new BabyFood();
        BeanUtils.copyProperties(bean, entity);
        babyFoodRepository.save(entity);
        return true;

    }

    public List<BabyFoodBean> fetchAllBabyFood(){
        List<BabyFoodBean> clothing;

        Iterable<BabyFood> iter = babyFoodRepository.findAll();

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

    private BabyFoodBean copyProperties(BabyFood entity){
        BabyFoodBean bean = new BabyFoodBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }
}
