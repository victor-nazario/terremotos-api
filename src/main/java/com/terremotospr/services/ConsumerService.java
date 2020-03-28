package com.terremotospr.services;

import com.terremotospr.beans.ConsumerBean;
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
}
