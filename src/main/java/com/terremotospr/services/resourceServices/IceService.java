package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.IceBean;
import com.terremotospr.database.entities.resourceEntities.Ice;
import com.terremotospr.database.repositories.resourceRepositories.IceRepository;
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
public class IceService {

    @Autowired
    IceRepository iceRepository;

    public Boolean addIce(IceBean bean) {
        if(bean == null) return false;

        Ice entity = new Ice();
        BeanUtils.copyProperties(bean, entity);
        iceRepository.save(entity);
        return true;
    }

    private IceBean copyProperties(Ice entity){
        IceBean bean = new IceBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<IceBean> fetchAllIce(){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findAll();

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public Ice findById(Integer id){ return iceRepository.findById(id);}

    public List<IceBean> findByPriceUnder(Double price){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findByPriceUnder(price);

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public List<IceBean> findByPriceOver(Double price){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findByPriceOver(price);

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public List<IceBean> findByBrand(String brand){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findByBrand(brand);

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public List<IceBean> findByName(String name){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findByName(name);

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public List<IceBean> findAvailable(){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findAvailable();

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public List<IceBean> findBySize(Double size){
        List<IceBean> ice;
        Iterable<Ice> iter = iceRepository.findBySize(size);

        ice = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return ice;
    }

    public Long countAllResources(){ return iceRepository.count();}
}