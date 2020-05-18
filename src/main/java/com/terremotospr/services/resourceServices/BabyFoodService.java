package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.BabyFoodBean;
import com.terremotospr.database.entities.resourceEntities.BabyFood;
import com.terremotospr.database.repositories.resourceRepositories.BabyFoodRepository;
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
        List<BabyFoodBean> babyFood;

        Iterable<BabyFood> iter = babyFoodRepository.findAll();

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    private BabyFoodBean copyProperties(BabyFood entity){
        BabyFoodBean bean = new BabyFoodBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public BabyFood findById(Integer id){
        return babyFoodRepository.findById(id);
    }

    public List<BabyFoodBean> findByPriceUnder(Double price){
        List<BabyFoodBean> babyFood;
        Iterable<BabyFood> iter = babyFoodRepository.findByPriceUnder(price);

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    public List<BabyFoodBean> findByBrand(String brand){
        List<BabyFoodBean> babyFood;
        Iterable<BabyFood> iter = babyFoodRepository.findByBrand(brand);

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    public List<BabyFoodBean> findByName(String name){
        List<BabyFoodBean> babyFood;
        Iterable<BabyFood> iter = babyFoodRepository.findByName(name);

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    public List<BabyFoodBean> findBySize(String size){
        List<BabyFoodBean> babyFood;
        Iterable<BabyFood> iter = babyFoodRepository.findBySize(size);

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    public List<BabyFoodBean> findAvailable(){
        List<BabyFoodBean> babyFood;

        Iterable<BabyFood> iter = babyFoodRepository.findAvailable();

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    public Long countAllResources(){ return babyFoodRepository.count();}
}
