package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.PropaneBean;
import com.terremotospr.database.entities.resourceEntities.Propane;
import com.terremotospr.database.repositories.resourceRepositories.PropaneRepository;
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
public class PropaneService {
    @Autowired
    PropaneRepository propaneRepository;

    public List<PropaneBean> fetchAllPropane(){
        List<PropaneBean> propane;

        Iterable<Propane> iter = propaneRepository.findAll();

        propane = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return propane;
    }

    private PropaneBean copyProperties(Propane entity){
        PropaneBean bean = new PropaneBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addPropane(PropaneBean bean) {
        if(bean == null) return false;

        Propane entity = new Propane();
        BeanUtils.copyProperties(bean, entity);
        propaneRepository.save(entity);
        return true;
    }

    public Propane findById(Integer id){ return propaneRepository.findById(id);}


    public List<PropaneBean> findByName(String name){
        List<PropaneBean> propane;
        Iterable<Propane> iter = propaneRepository.findByName(name);

        propane = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return propane;
    }

    public List<PropaneBean> findAvailable(){
        List<PropaneBean> propane;
        Iterable<Propane> iter = propaneRepository.findAvailable();

        propane = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return propane;
    }

    public Long countAllResources(){ return propaneRepository.count();}
}
