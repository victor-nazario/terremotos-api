package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.ClothingBean;
import com.terremotospr.database.entities.resourceEntities.Clothing;
import com.terremotospr.database.repositories.resourceRepositories.ClothingRepository;
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
public class ClothingService {

    @Autowired
    ClothingRepository clothingRepository;

    public Boolean addClothing(ClothingBean bean){
        if(bean == null) return false;

        Clothing entity = new Clothing();
        BeanUtils.copyProperties(bean, entity);
        clothingRepository.save(entity);
        return true;

    }

    public List<ClothingBean> fetchAllClothing(){
        List<ClothingBean> clothing;

        Iterable<Clothing> iter = clothingRepository.findAll();

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

    private ClothingBean copyProperties(Clothing entity){
        ClothingBean bean = new ClothingBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }


}
