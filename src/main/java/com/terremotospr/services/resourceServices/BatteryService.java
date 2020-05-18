package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.BatteryBean;
import com.terremotospr.database.entities.resourceEntities.Battery;
import com.terremotospr.database.repositories.resourceRepositories.BatteryRepository;
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
public class BatteryService {

    @Autowired
    BatteryRepository batteryRepository;

    public List<BatteryBean> fetchAllBattery(){
        List<BatteryBean> batteries;

        Iterable<Battery> iter = batteryRepository.findAll();

        batteries = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return batteries;
    }

    private BatteryBean copyProperties(Battery entity){
        BatteryBean bean = new BatteryBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addBattery(BatteryBean bean) {
        if(bean == null) return false;

        Battery entity = new Battery();
        BeanUtils.copyProperties(bean, entity);
        batteryRepository.save(entity);
        return true;
    }


    public Battery findById(Long id){
        return batteryRepository.findById(id).get();
    }

    public List<BatteryBean> findByPriceUnder(Double price){
        List<BatteryBean> batterries;
        Iterable<Battery> iter = batteryRepository.findByPriceUnder(price);

        batterries = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return batterries;
    }


    public List<BatteryBean> findByName(String name){
        List<BatteryBean> batteries;
        Iterable<Battery> iter = batteryRepository.findByName(name);

        batteries = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return batteries;
    }

    public List<BatteryBean> findAvailable(){
        List<BatteryBean> batteries;
        Iterable<Battery> iter = batteryRepository.findAvailable();

        batteries = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return batteries;
    }

    public Long countAllResources() {
        return batteryRepository.count();
    }
}
