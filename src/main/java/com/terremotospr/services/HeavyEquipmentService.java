package com.terremotospr.services;

import com.terremotospr.beans.HeavyEquipmentBean;
import com.terremotospr.database.entities.HeavyEquipment;
import com.terremotospr.database.repositories.HeavyEquipmentRepository;
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

}
