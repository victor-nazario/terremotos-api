package com.terremotospr.services;

import com.terremotospr.beans.OrderBean;
import com.terremotospr.entities.Order;
import com.terremotospr.repositories.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on mARCH 7, 2020 - 9:18 PM
 *
 * @author Victor Nazario
 */

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderBean> fetchAllOrder(){
        List<OrderBean> orders;
        Iterable<Order> iterable = orderRepository.findAll();


        orders = StreamSupport.stream(iterable.spliterator(), false)
                .map(this::convertOrders)
                .collect(Collectors.toList());

        return orders;
    }


    private OrderBean convertOrders(Order entity) {
        OrderBean bean = new OrderBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }
}
