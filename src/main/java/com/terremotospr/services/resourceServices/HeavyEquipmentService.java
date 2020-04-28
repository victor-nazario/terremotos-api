package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.HeavyEquipmentBean;
import com.terremotospr.beans.resourceBeans.TypeofHeavyEquipment;
import com.terremotospr.database.entities.resourceEntities.HeavyEquipment;
import com.terremotospr.database.repositories.resourceRepositories.HeavyEquipmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HeavyEquipmentService {
    @Autowired
    HeavyEquipmentRepository heavyEquipmentRepository;

    public Boolean addHeavyEquipment(HeavyEquipmentBean bean) {
        if(bean == null) return false;

        HeavyEquipment entity = new HeavyEquipment();
        BeanUtils.copyProperties(bean, entity);
        heavyEquipmentRepository.save(entity);
        return true;
    }

    private HeavyEquipmentBean copyProperties(HeavyEquipment entity){
        HeavyEquipmentBean bean = new HeavyEquipmentBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<HeavyEquipmentBean> fetchAllHeavyEquipment(){
        List<HeavyEquipmentBean> heavyEquipment;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findAll();

        heavyEquipment = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipment;
    }

    public HeavyEquipment findById(Integer id){ return heavyEquipmentRepository.findById(id);}

    public List<HeavyEquipmentBean> findByPriceUnder(Double price){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findByPriceUnder(price);

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

    public List<HeavyEquipmentBean> findByPriceOver(Double price){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findByPriceOver(price);

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

    public List<HeavyEquipmentBean> findByBrand(String brand){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findByBrand(brand);

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

    public List<HeavyEquipmentBean> findByName(String name){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findByName(name);

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

    public List<HeavyEquipmentBean> findAvailable(){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findAvailable();

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

    public List<HeavyEquipmentBean> findBySize(Double size){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findBySize(size);

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

    public List<HeavyEquipmentBean> findByType(TypeofHeavyEquipment type){
        List<HeavyEquipmentBean> heavyEquipments;
        Iterable<HeavyEquipment> iter = heavyEquipmentRepository.findByType(type);

        heavyEquipments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return heavyEquipments;
    }

}
