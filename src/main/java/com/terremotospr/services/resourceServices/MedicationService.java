package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.MedicationBean;
import com.terremotospr.database.entities.resourceEntities.Medication;
import com.terremotospr.database.repositories.resourceRepositories.MedicationRepository;
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
public class MedicationService {

    @Autowired
    MedicationRepository medicationRepository;

    public Boolean addMedication(MedicationBean bean) {
        if(bean == null) return false;

        Medication entity = new Medication();
        BeanUtils.copyProperties(bean, entity);
        medicationRepository.save(entity);
        return true;


    }

    public List<MedicationBean> fetchAllMedication(){
        List<MedicationBean> medications;

        Iterable<Medication> iter = medicationRepository.findAll();

        medications = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medications;
    }

    private MedicationBean copyProperties(Medication entity){
        MedicationBean bean = new MedicationBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

//    public DryFood findById(Integer id){
//        return medicationRepository.findById(id);
//    }

    public List<MedicationBean> findByPriceUnder(Double price){
        List<MedicationBean> medication;
        Iterable<Medication> iter = medicationRepository.findByPriceUnder(price);

        medication = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medication;
    }

    public List<MedicationBean> findByBrand(String brand){
        List<MedicationBean> medication;
        Iterable<Medication> iter = medicationRepository.findByBrand(brand);

        medication = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medication;
    }

    public List<MedicationBean> findByName(String name){
        List<MedicationBean> medication;
        Iterable<Medication> iter = medicationRepository.findByName(name);

        medication = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medication;
    }

    public List<MedicationBean> findBySize(String size){
        List<MedicationBean> medication;
        Iterable<Medication> iter = medicationRepository.findBySize(size);

        medication = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medication;
    }

    public List<MedicationBean> findAvailable(){
        List<MedicationBean> medication;

        Iterable<Medication> iter = medicationRepository.findAvailable();

        medication = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return medication;
    }
}
