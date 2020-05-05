package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.ConsumerBean;
import com.terremotospr.beans.administrativeBeans.ConsumerType;
import com.terremotospr.database.entities.administrativeEntities.Consumer;
import com.terremotospr.database.repositories.administrativeRepositories.ConsumerRepository;
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
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public Boolean addConsumer(ConsumerBean bean) {
        if(bean == null) return false;

        Consumer entity = new Consumer();
        BeanUtils.copyProperties(bean, entity);
        consumerRepository.save(entity);
        return true;
    }

    private ConsumerBean copyProperties(Consumer entity){
        ConsumerBean bean = new ConsumerBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<ConsumerBean> fetchAllConsumer(){
        List<ConsumerBean> consumers;
        Iterable<Consumer> iter = consumerRepository.findAll();

        consumers = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return consumers;
    }

    public Consumer findConsumerById(Integer id){
        return consumerRepository.findById(id).get();
    }

    public List<ConsumerBean> findByCity(String city){
        List<ConsumerBean> consumer;
        Iterable<Consumer> iter = consumerRepository.findByCity(city);

        consumer = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return consumer;
    }

    public List<ConsumerBean> findByRegion(String region){
        List<ConsumerBean> consumer;
        Iterable<Consumer> iter = consumerRepository.findByRegion(region);

        consumer = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return consumer;
    }

    public List<ConsumerBean> findByType(String type){
        List<ConsumerBean> consumer;
        Iterable<Consumer> iter = consumerRepository.findByType(type);

        consumer = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return consumer;
    }
}
