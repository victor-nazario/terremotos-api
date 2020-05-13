package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.TypeOfWater;
import com.terremotospr.beans.resourceBeans.WaterBean;
import com.terremotospr.database.entities.resourceEntities.Water;
import com.terremotospr.database.repositories.resourceRepositories.WaterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on 12 March, 2020 - 9:20 PM
 *
 * @author Victor Nazario
 */

@Service
public class WaterService {

    @Autowired
    WaterRepository waterRepository;

    public List<WaterBean> fetchAllWater(){
      List<WaterBean> waters;

      Iterable<Water> iter = waterRepository.findAll();

      waters = StreamSupport.stream(iter.spliterator(), false)
              .map(this::copyProperties)
              .collect(Collectors.toList());

      return waters;
    }

    private WaterBean copyProperties(Water entity){
        WaterBean bean = new WaterBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setCategory(entity.getCategory());
        bean.setExpirationDate(new Date());
        return bean;
    }

    public boolean addWater(WaterBean bean) {
        if(bean == null) return false;

        Water entity = new Water();
        BeanUtils.copyProperties(bean, entity);
        waterRepository.save(entity);
        return true;
    }

    public WaterBean findById(Long id){
        return copyProperties(waterRepository.findById(id).get());
    }

    public List<WaterBean> findByPriceUnder(Double price){
        List<WaterBean> waters;
        Iterable<Water> iter = waterRepository.findAllByPriceIsLessThan(price);

        waters = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return waters;
    }

    public List<WaterBean> findByBrand(String brand){
        List<WaterBean> waters;
        Iterable<Water> iter = waterRepository.findAllByBrandEquals(brand);

        waters = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return waters;
    }

    public List<WaterBean> findByName(String name){
        List<WaterBean> waters;
        Iterable<Water> iter = waterRepository.findByName(name);

        waters = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return waters;
    }

    public List<WaterBean> findAvailable(){
        List<WaterBean> waters;
        Iterable<Water> iter = waterRepository.findAvailable();

        waters = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return waters;
    }

    public List<WaterBean> findByWaterType(TypeOfWater type){
        List<WaterBean> waters;
        Iterable<Water> iter = waterRepository.findAllByTypeEquals(type);

        waters = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return waters;
    }
}
