package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.CannedFoodBean;
import com.terremotospr.database.entities.resourceEntities.CannedFood;
import com.terremotospr.database.repositories.resourceRepositories.CannedFoodRepository;
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
public class CannedFoodService {

    @Autowired
    CannedFoodRepository cannedFoodRepository;

    public Boolean addCannedFood(CannedFoodBean bean) {
        if(bean == null) return false;

        CannedFood entity = new CannedFood();
        BeanUtils.copyProperties(bean, entity);
        cannedFoodRepository.save(entity);
        return true;
    }

    private CannedFoodBean copyProperties(CannedFood entity){
        CannedFoodBean bean = new CannedFoodBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<CannedFoodBean> fetchAllCannedFood(){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findAll();

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public CannedFood findById(Integer id){ return cannedFoodRepository.findById(id);}

    public List<CannedFoodBean> findByPriceUnder(Double price){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findByPriceUnder(price);

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public List<CannedFoodBean> findByPriceOver(Double price){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findByPriceOver(price);

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public List<CannedFoodBean> findByBrand(String brand){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findByBrand(brand);

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public List<CannedFoodBean> findByName(String name){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findByName(name);

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public List<CannedFoodBean> findAvailable(){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findAvailable();

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public List<CannedFoodBean> findBySize(Double size){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findBySize(size);

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }

    public List<CannedFoodBean> findByType(String type){
        List<CannedFoodBean> cannedFoods;
        Iterable<CannedFood> iter = cannedFoodRepository.findByType(type);

        cannedFoods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cannedFoods;
    }
}
