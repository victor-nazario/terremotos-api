package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.administrativeBeans.BelongsBean;
import com.terremotospr.beans.paymentBeans.PlacedOrderBean;
import com.terremotospr.database.entities.administrativeEntities.Belongs;
import com.terremotospr.database.entities.paymentEntities.PlacedOrder;
import com.terremotospr.database.entities.resourceEntities.BaseResource;
import com.terremotospr.database.entities.resourceEntities.PowerGen;
import com.terremotospr.database.repositories.administrativeRepositories.ConsumerRepository;
import com.terremotospr.database.repositories.paymentRepositories.PlacedOrderRepository;
import com.terremotospr.database.repositories.resourceRepositories.BaseResourceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    BaseResourceRepository baseResourceRepository;


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
        bean.setCustomerId(entity.getConsumer().getId());

        Set<BelongsBean> belongsSet = new HashSet<>();
        Set<Belongs> belongs = entity.getBelongs();


        for(Belongs belongsEntity: belongs){
            BelongsBean belongsBean = new BelongsBean();
            belongsBean.setFinalPrice(belongsEntity.getFinalPrice());
            belongsBean.setResourceId(belongsEntity.getResourceId());
            belongsBean.setOrderId(belongsEntity.getOrderId());
            belongsBean.setQuantity(belongsEntity.getQuantity());
            belongsSet.add(belongsBean);
        }

        bean.setBelongsBeans(belongsSet);
        return bean;
    }

    public boolean addOrder(PlacedOrderBean bean) {
        if(bean == null) return false;

        PlacedOrder entity = new PlacedOrder();
        BeanUtils.copyProperties(bean, entity);
        entity.setConsumer(consumerRepository.findConsumerById(bean.getCustomerId()).get());

        Set<BelongsBean> belongsBeanSet = bean.getBelongsBeans();
        Set<Belongs> belongs = new HashSet<>();

        for(BelongsBean belongsBean : belongsBeanSet){
            Belongs belongEntity = new Belongs();
            BaseResource resource = baseResourceRepository.findById(belongsBean.getResourceId()).get();
            belongEntity.setResourceId(belongsBean.getResourceId());
            belongEntity.setOrderId(belongsBean.getOrderId());
            belongEntity.setFinalPrice(resource.getPrice()*belongsBean.getQuantity());
            belongEntity.setQuantity(belongsBean.getQuantity());
            belongEntity.setOrderId(placedOrderRepository.findTopByOrderByIdDesc().get().getId()+10);
            belongs.add(belongEntity);
        }

        entity.setBelongs(belongs);
        placedOrderRepository.save(entity);
        return true;
    }

    public PlacedOrderBean findById(Long id){
        return copyProperties(placedOrderRepository.findById(id).get());
    }


    /* public List<BaseResourceBean> fetchByDay(boolean isWeekly){
        Calendar calendar = Calendar.getInstance();
        if(isWeekly){
            calendar.add(Calendar.HOUR_OF_DAY, -168);
        }
        else
            calendar.add(Calendar.HOUR_OF_DAY, -24);

        Date date = calendar.getTime();

        List<BaseResourceBean> resourceBeans = new ArrayList<>();

        List<PlacedOrder> placedOrders = placedOrderRepository.findAllWithCreationDateTimeBefore(date, new Date());
        List<Belongs> belongsTimeFrame = new ArrayList<>();

        for(PlacedOrder placedOrder : placedOrders){
            belongsTimeFrame.addAll(placedOrder.getBelongs());
        }

        for (Belongs belongs : belongsTimeFrame){
            BaseResource baseR = baseResourceRepository.findById(belongs.getResourceId()).get();
            resourceBeans.add(copyProperties(baseR));
        }

        return  resourceBeans;
    }*/
    public Integer WeeklyCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -168);
        Date date = calendar.getTime();

        return placedOrderRepository.findAllWithCreationDateTimeBefore(date, new Date()).size();
    }
}
