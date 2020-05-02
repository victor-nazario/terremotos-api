package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.MedicalDevicesBean;
import com.terremotospr.beans.resourceBeans.medicalDeviceType;
import com.terremotospr.database.entities.resourceEntities.MedicalDevices;
import com.terremotospr.database.repositories.resourceRepositories.MedicalDevicesRepository;
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

    public List<MedicalDevicesBean> findAvailable(){
        List<MedicalDevicesBean> clothing;

        Iterable<MedicalDevices> iter = medicalDevicesRepository.findAvailable();

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

    public List<MedicalDevicesBean> findByBrand(String brand){
        List<MedicalDevicesBean> clothing;

        Iterable<MedicalDevices> iter = medicalDevicesRepository.findByBrand(brand);

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

    public List<MedicalDevicesBean> findByName(String name){
        List<MedicalDevicesBean> clothing;

        Iterable<MedicalDevices> iter = medicalDevicesRepository.findByName(name);

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

    public List<MedicalDevicesBean> findByPriceUnder(Double price){
        List<MedicalDevicesBean> clothing;

        Iterable<MedicalDevices> iter = medicalDevicesRepository.findByPriceUnder(price);

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

    public MedicalDevices findById(Integer id){
        return medicalDevicesRepository.findById(id);
    }

    public List<MedicalDevicesBean> findByType(medicalDeviceType type){
        List<MedicalDevicesBean> clothing;

        Iterable<MedicalDevices> iter = medicalDevicesRepository.findByType(type);

        clothing = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return clothing;
    }

}
