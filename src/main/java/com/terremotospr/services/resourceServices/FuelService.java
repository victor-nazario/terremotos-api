package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.FuelBean;
import com.terremotospr.database.entities.resourceEntities.Fuel;
import com.terremotospr.database.repositories.resourceRepositories.FuelRepository;
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
public class FuelService {

    @Autowired
    FuelRepository fuelRepository;

    public List<FuelBean> fetchAllFuel(){
        List<FuelBean> fuels;

        Iterable<Fuel> iter = fuelRepository.findAll();

        fuels = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return fuels;
    }

    private FuelBean copyProperties(Fuel entity){
        FuelBean bean = new FuelBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addFuel(FuelBean bean) {
        if(bean == null) return false;

        Fuel entity = new Fuel();
        BeanUtils.copyProperties(bean, entity);
        fuelRepository.save(entity);
        return true;
    }

    public Fuel findById(Long id) {
        return fuelRepository.findById(id).get();
    }

    public List<FuelBean> findByName(String name){
        List<FuelBean> fuels;
        Iterable<Fuel> iter = fuelRepository.findByName(name);

        fuels = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return fuels;
    }

    public List<FuelBean> findAvailable() {
        List<FuelBean> fuels;
        Iterable<Fuel> iter = fuelRepository.findAvailable();

        fuels = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return fuels;
    }

    public Long countAllResources() {
        return fuelRepository.count();
    }
}
