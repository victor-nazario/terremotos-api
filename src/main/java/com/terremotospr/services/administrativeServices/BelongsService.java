package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.BelongsBean;
import com.terremotospr.database.entities.administrativeEntities.Belongs;
import com.terremotospr.database.entities.resourceEntities.BaseResource;
import com.terremotospr.database.repositories.administrativeRepositories.BelongsRepository;
import com.terremotospr.database.repositories.resourceRepositories.BaseResourceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BelongsService {
    @Autowired
    BelongsRepository belongsRepository;

    @Autowired
    BaseResourceRepository baseResourceRepository;

    public Boolean addBelongs(BelongsBean bean){
        if(bean == null) return false;

        Belongs entity = new Belongs();
        BeanUtils.copyProperties(bean, entity, "resource", "placedOrder");
        entity.setOrderId(bean.getOrderId());
        entity.setResourceId(bean.getResourceId());

        BaseResource resource = baseResourceRepository.findById(bean.getResourceId()).get();
        entity.setFinalPrice(resource.getPrice() * bean.getQuantity());
        entity.setQuantity(bean.getQuantity());

        belongsRepository.save(entity);
        return true;
    }

    private BelongsBean copyProperties(Belongs entity){
        BelongsBean bean = new BelongsBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<BelongsBean> fetchAllBelongs(){
        List<BelongsBean> belongs;
        Iterable<Belongs> iter = belongsRepository.findAll();

        belongs = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return belongs;
    }

    public List<BelongsBean> findByOrderId(Integer orderId){
        List<BelongsBean> belongs;
        Iterable<Belongs> iter = belongsRepository.findByOrderId(orderId);

        belongs = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return belongs;
    }

    public List<BelongsBean> findByResourceId(Integer resourceId){
        List<BelongsBean> belongs;
        Iterable<Belongs> iter = belongsRepository.findByResourceId(resourceId);

        belongs = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return belongs;
    }

}
