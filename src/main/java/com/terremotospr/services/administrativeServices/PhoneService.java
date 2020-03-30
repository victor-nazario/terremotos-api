package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.PhoneBean;
import com.terremotospr.database.entities.administrativeEntities.Phone;
import com.terremotospr.database.repositories.administrativeRepositories.PhoneRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on March 17, 2020 - 12:38PM
 *
 * @author Victor Nazario
 */

@Service
public class PhoneService {

    @Autowired
    PhoneRepository phoneRepository;

    public List<PhoneBean> fetchAllPhone(){
        List<PhoneBean> phones;

        Iterable<Phone> iter = phoneRepository.findAll();

        phones = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return phones;
    }

    public boolean addPhone(PhoneBean bean) {
        if(bean == null) return false;

        Phone entity = new Phone();
        BeanUtils.copyProperties(bean, entity, "consumer");
        entity.setConsumerId(bean.getConsumerId());
        phoneRepository.save(entity);
        return true;
    }



    private PhoneBean copyProperties(Phone entity){
        PhoneBean bean = new PhoneBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }
}
