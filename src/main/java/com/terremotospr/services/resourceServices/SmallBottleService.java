package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.SmallBottleBean;
import com.terremotospr.beans.resourceBeans.TypeOfWater;
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

    public SmallBottle findById(Integer id){ return smallBottleRepository.findById(id);}

    public List<SmallBottleBean> findByPriceUnder(Double price){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findByPriceUnder(price);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findByPriceOver(Double price){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findByPriceOver(price);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findByBrand(String brand){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findByBrand(brand);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findByName(String name){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findByName(name);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findAvailable(){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findAvailable();

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findBySize(Double size){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findBySize(size);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findByType(TypeOfWater type){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findByType(type);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }
    public List<SmallBottleBean> findPotable(){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findPotable();

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

    public List<SmallBottleBean> findByPackagedQuantity(int packagedQuantity){
        List<SmallBottleBean> smallBottles;
        Iterable<SmallBottle> iter = smallBottleRepository.findByPackagedQuantity(packagedQuantity);

        smallBottles = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return smallBottles;
    }

}
