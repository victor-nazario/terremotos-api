package com.terremotospr.services;

import com.terremotospr.beans.MedicalDevicesBean;
import com.terremotospr.database.entities.MedicalDevices;
import com.terremotospr.database.repositories.MedicalDevicesRepository;
import com.terremotospr.database.repositories.MedicationRepository;
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
public class MedicalDevicesService {
    @Autowired
    MedicalDevicesRepository medicalDevicesRepository;

    public Boolean addMedicalDevice(MedicalDevicesBean bean){
        if(bean == null) return false;

        MedicalDevices entity = new MedicalDevices();
        BeanUtils.copyProperties(bean, entity);
        medicalDevicesRepository.save(entity);
        return true;

    }

    public List<MedicalDevicesBean> fetchAllMedicalDevices(){
        List<MedicalDevicesBean> medicalDevices;

        Iterable<MedicalDevices> iter = medicalDevicesRepository.findAll();

        medicalDevices = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medicalDevices;
    }

    private MedicalDevicesBean copyProperties(MedicalDevices entity){
        MedicalDevicesBean bean = new MedicalDevicesBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

}
