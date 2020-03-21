package com.terremotospr.services;

import com.terremotospr.beans.PlacedOrderBean;
import com.terremotospr.database.entities.PlacedOrder;
import com.terremotospr.database.repositories.PlacedOrderRepository;
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
public class PlacedOrderService {

    @Autowired
    PlacedOrderRepository placedOrderRepository;

    public List<PlacedOrderBean> fetchAllOrder(){
        List<PlacedOrderBean> order;

        Iterable<PlacedOrder> iter = placedOrderRepository.findAll();

        order = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return order;
    }

    private PlacedOrderBean copyProperties(PlacedOrder entity){
        PlacedOrderBean bean = new PlacedOrderBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addOrder(PlacedOrderBean bean) {
        if(bean == null) return false;

        PlacedOrder entity = new PlacedOrder();
        BeanUtils.copyProperties(bean, entity);
        placedOrderRepository.save(entity);
        return true;
    }
}
