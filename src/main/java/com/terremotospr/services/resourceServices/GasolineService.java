package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.GasolineBean;
import com.terremotospr.database.entities.resourceEntities.Gasoline;
import com.terremotospr.database.repositories.resourceRepositories.GasolineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@Service
public class GasolineService {

    @Autowired
    GasolineRepository gasolineRepository;

    public Boolean addGasoline(GasolineBean bean) {
        if(bean == null) return false;

        Gasoline entity = new Gasoline();
        BeanUtils.copyProperties(bean, entity);
        gasolineRepository.save(entity);
        return true;
    }

    private GasolineBean copyProperties(Gasoline entity){
        GasolineBean bean = new GasolineBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<GasolineBean> fetchAllGasoline(){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findAll();

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public Gasoline findById(Integer id){ return gasolineRepository.findById(id);}

    public List<GasolineBean> findByPriceUnder(Double price){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findByPriceUnder(price);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findByPriceOver(Double price){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findByPriceOver(price);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findByBrand(String brand){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findByBrand(brand);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findByName(String name){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findByName(name);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findAvailable(){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findAvailable();

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findBySize(Double size){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findBySize(size);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findByOctane(Double octane){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findByOctane(octane);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public List<GasolineBean> findByGasolineType(String gasolineType){
        List<GasolineBean> gasoline;
        Iterable<Gasoline> iter = gasolineRepository.findByType(gasolineType);

        gasoline = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return gasoline;
    }

    public Long countAllResources(){ return gasolineRepository.count();}

}