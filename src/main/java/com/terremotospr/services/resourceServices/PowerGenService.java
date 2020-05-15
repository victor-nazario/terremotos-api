package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.PowerGenBean;
import com.terremotospr.beans.resourceBeans.PowerGeneratorType;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
import com.terremotospr.database.repositories.resourceRepositories.BaseResourceRepository;
import com.terremotospr.database.repositories.resourceRepositories.PowerGenRepository;
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
public class PowerGenService {
    @Autowired
    PowerGenRepository powerGenRepository;

    @Autowired
    BaseResourceRepository baseResourceRepository;

    public Boolean addPowerGen(PowerGenBean bean){
        if(bean == null) return false;

        PowerGen entity = new PowerGen();
        BeanUtils.copyProperties(bean, entity);
        powerGenRepository.save(entity);
        return true;

    }

    public List<PowerGenBean> fetchAllPowerGen(){
        List<PowerGenBean> babyFood;

        Iterable<PowerGen> iter = powerGenRepository.findAll();

        babyFood = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return babyFood;
    }

    private PowerGenBean copyProperties(PowerGen entity){
        PowerGenBean bean = new PowerGenBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public PowerGen findById(Integer id){
        return powerGenRepository.findById(id);
    }

    public List<PowerGenBean> findByPriceUnder(Double price){
        List<PowerGenBean> powerGen;
        Iterable<PowerGen> iter = powerGenRepository.findByPriceUnder(price);

        powerGen = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return powerGen;
    }

    public List<PowerGenBean> findByBrand(String brand){
        List<PowerGenBean> powerGen;
        Iterable<PowerGen> iter = powerGenRepository.findByBrand(brand);

        powerGen = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return powerGen;
    }

    public List<PowerGenBean> findByName(String name){
        List<PowerGenBean> powerGen;
        Iterable<PowerGen> iter = powerGenRepository.findByName(name);

        powerGen = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return powerGen;
    }

    public List<PowerGenBean> findByPower(String power){
        List<PowerGenBean> powerGen;
        Iterable<PowerGen> iter = powerGenRepository.findByPower(power);

        powerGen = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return powerGen;
    }

    public List<PowerGenBean> findByGeneratorType(PowerGeneratorType type){
        List<PowerGenBean> powerGen;
        Iterable<PowerGen> iter = powerGenRepository.findByGeneratorType(type);

        powerGen = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return powerGen;
    }



}
