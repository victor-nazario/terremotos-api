package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.BatteryBean;
import com.terremotospr.beans.resourceBeans.GallonBottleBean;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Battery;
import com.terremotospr.database.entities.resourceEntities.GallonBottle;
import com.terremotospr.database.entities.resourceEntities.Water;
import com.terremotospr.database.repositories.resourceRepositories.GallonBottleRepository;
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
public class GallonBottleService {
    @Autowired
    GallonBottleRepository gallonBottleRepository;

    public List<GallonBottleBean> fetchAllGallon(){
        List<GallonBottleBean> gallonBottles;

        Iterable<GallonBottle> iter = gallonBottleRepository.findAll();

        gallonBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gallonBottles;
    }

    private GallonBottleBean copyProperties(GallonBottle entity){
        GallonBottleBean bean = new GallonBottleBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addGallon(GallonBottleBean bean) {
        if(bean == null) return false;

        GallonBottle entity = new GallonBottle();
        BeanUtils.copyProperties(bean, entity);
        gallonBottleRepository.save(entity);
        return true;
    }

    public GallonBottle findById(Long id){
        return gallonBottleRepository.findById(id).get();
    }

    public List<GallonBottleBean> findByPriceUnder(Double price){
        List<GallonBottleBean> bottles;
        Iterable<GallonBottle> iter = gallonBottleRepository.findByPriceUnder(price);

        bottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return bottles;
    }
}
