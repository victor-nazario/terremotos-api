package com.terremotospr.services;

import com.terremotospr.beans.ManagesBean;
import com.terremotospr.database.entities.administrativeEntities.Manages;
import com.terremotospr.database.repositories.administrativeRepositories.ManagesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */

@Service
public class ManagesService {
    @Autowired
    ManagesRepository managesRepository;

    public Boolean addManages(ManagesBean bean) {
        if(bean == null) return false;

        Manages entity = new Manages();
        BeanUtils.copyProperties(bean, entity, "admin", "user");
        entity.setAdminId(bean.getAdminId());
        entity.setUserId(bean.getUserId());
        managesRepository.save(entity);
        return true;
    }

    private ManagesBean copyProperties(Manages entity){
        ManagesBean bean = new ManagesBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<ManagesBean> fetchAllManages(){
        List<ManagesBean> manages;
        Iterable<Manages> iter = managesRepository.findAll();

        manages = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return manages;
    }
}